import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;
import java.lang.reflect.Method;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {
    }

    public EmployeeBean(String employeeId, String firstName, String lastName, double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = Math.max(0, salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getYearsOfService() {
        if (hireDate == null) return 0;
        Calendar start = Calendar.getInstance();
        start.setTime(hireDate);
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - start.get(Calendar.YEAR);
    }

    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance().format(salary);
    }

    public void setFullName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            String[] parts = fullName.split(" ", 2);
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", yearsOfService=" + getYearsOfService() +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean e1 = new EmployeeBean();
        e1.setEmployeeId("E001");
        e1.setFirstName("Ayush");
        e1.setLastName("Sharma");
        e1.setSalary(50000);
        e1.setDepartment("IT");
        e1.setHireDate(new Date(120, 0, 1));
        e1.setActive(true);

        EmployeeBean e2 = new EmployeeBean("E002", "Daksh", "Gupta", 60000, "HR", new Date(118, 5, 10), true);

        System.out.println(e1.getFullName());
        System.out.println(e2.getFullName());
        System.out.println(e1.getFormattedSalary());
        System.out.println(e2.getYearsOfService());

        List<EmployeeBean> employees = new ArrayList<>(Arrays.asList(e1, e2));
        employees.sort(Comparator.comparingDouble(EmployeeBean::getSalary));
        employees.forEach(System.out::println);

        List<EmployeeBean> activeEmployees = new ArrayList<>();
        for (EmployeeBean emp : employees) {
            if (emp.isActive()) activeEmployees.add(emp);
        }
        activeEmployees.forEach(System.out::println);

        JavaBeanProcessor.printAllProperties(e1);
        EmployeeBean e3 = new EmployeeBean();
        JavaBeanProcessor.copyProperties(e1, e3);
        System.out.println(e3);
    }
}

class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        try {
            for (Method m : emp.getClass().getMethods()) {
                if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
                    Object value = m.invoke(emp);
                    System.out.println(m.getName() + " = " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        try {
            for (Method m : source.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterCount() == 0) {
                    Object value = m.invoke(source);
                    String setterName = "set" + m.getName().substring(3);
                    try {
                        Method setter = target.getClass().getMethod(setterName, m.getReturnType());
                        setter.invoke(target, value);
                    } catch (NoSuchMethodException ignored) {}
                }
                if (m.getName().startsWith("is") && m.getParameterCount() == 0) {
                    Object value = m.invoke(source);
                    String setterName = "set" + m.getName().substring(2);
                    try {
                        Method setter = target.getClass().getMethod(setterName, m.getReturnType());
                        setter.invoke(target, value);
                    } catch (NoSuchMethodException ignored) {}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
