class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int counter = 1;

    // Full-time constructor
    public Employee(String name, String department, double baseSalary) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    // Part-time constructor
    public Employee(String name, String department, double hourlyRate, int hours) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = department;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    // Contract constructor
    public Employee(String name, String department, double fixedAmount, boolean isContract) {
        this.empId = generateEmpId();
        this.empName = name;
        this.department = department;
        this.baseSalary = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    // Overloaded calculateSalary()
    public double calculateSalary(double bonus) { // Full-time
        if (empType.equals("Full-Time")) {
            return baseSalary + bonus;
        }
        return baseSalary;
    }

    public double calculateSalary(int hours, double hourlyRate) { // Part-time
        if (empType.equals("Part-Time")) {
            return hours * hourlyRate;
        }
        return baseSalary;
    }

    public double calculateSalary() { // Contract
        return baseSalary;
    }

    // Overloaded calculateTax()
    public double calculateTax(double salary) { // Full-time tax 20%
        if (empType.equals("Full-Time")) {
            return salary * 0.20;
        }
        return 0;
    }

    public double calculateTax(double salary, boolean isPartTime) { // Part-time tax 10%
        if (empType.equals("Part-Time")) {
            return salary * 0.10;
        }
        return 0;
    }

    public double calculateTax() { // Contract tax 5%
        if (empType.equals("Contract")) {
            return baseSalary * 0.05;
        }
        return 0;
    }

    public void generatePaySlip(double salary, double tax) {
        System.out.println("===== Pay Slip =====");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name       : " + empName);
        System.out.println("Department : " + department);
        System.out.println("Type       : " + empType);
        System.out.println("Gross Salary: " + salary);
        System.out.println("Tax Deducted: " + tax);
        System.out.println("Net Salary : " + (salary - tax));
        System.out.println("====================\n");
    }

    public void displayEmployeeInfo() {
        System.out.println("ID: " + empId + ", Name: " + empName +
                ", Dept: " + department + ", Type: " + empType);
    }

    private static String generateEmpId() {
        return "EMP" + String.format("%03d", counter++);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        // Full-time employee
        Employee e1 = new Employee("Alice", "IT", 50000);
        double fullTimeSalary = e1.calculateSalary(10000);
        double fullTimeTax = e1.calculateTax(fullTimeSalary);
        e1.generatePaySlip(fullTimeSalary, fullTimeTax);

        // Part-time employee
        Employee e2 = new Employee("Bob", "Support", 200, 80);
        double partTimeSalary = e2.calculateSalary(80, 200);
        double partTimeTax = e2.calculateTax(partTimeSalary, true);
        e2.generatePaySlip(partTimeSalary, partTimeTax);

        // Contract employee
        Employee e3 = new Employee("Charlie", "HR", 40000, true);
        double contractSalary = e3.calculateSalary();
        double contractTax = e3.calculateTax();
        e3.generatePaySlip(contractSalary, contractTax);

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}