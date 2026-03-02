public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("E001", "Alice", 50000);
        Employee e2 = new Employee("E002", "Bob", 60000);
        Employee e3 = new Employee("E003", "Charlie", 55000);

        Employee[] employees = { e1, e2, e3 };

        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("Class name: " + e.getClass().getName());
            System.out.println();
        }
    }
}

class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[ID: " + id + ", Name: " + name + ", Salary: $" + salary + "]";
    }
}