import java.util.*;

abstract class Employee {
    String empId;
    String empName;
    String department;
    String designation;
    double baseSalary;
    String joinDate;
    boolean[] attendanceRecord;
    int leavesTaken;

    static int totalEmployees = 0;
    static String companyName = "TechCorp Pvt Ltd";
    static double totalSalaryExpense = 0.0;
    static int workingDaysPerMonth = 30;

    public Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        this.leavesTaken = 0;
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= workingDaysPerMonth) {
            attendanceRecord[day - 1] = present;
            if (!present) leavesTaken++;
        }
    }

    public abstract double calculateSalary();

    public double calculateBonus() {
        int presentDays = 0;
        for (boolean p : attendanceRecord) if (p) presentDays++;
        double attendanceRate = (double) presentDays / workingDaysPerMonth;
        if (attendanceRate >= 0.9) return baseSalary * 0.1;   // 10% bonus
        if (attendanceRate >= 0.75) return baseSalary * 0.05; // 5% bonus
        return 0.0;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        double total = salary + bonus;
        totalSalaryExpense += total;
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Company: " + companyName);
        System.out.println("Employee: " + empName + " (" + designation + ")");
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Calculated Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Net Pay: " + total);
    }

    public void requestLeave(int days) {
        leavesTaken += days;
        System.out.println(empName + " has requested " + days + " days leave. Total leaves now: " + leavesTaken);
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    @Override
    public double calculateSalary() {
        int presentDays = 0;
        for (boolean p : attendanceRecord) if (p) presentDays++;
        return (baseSalary / workingDaysPerMonth) * presentDays;
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String empId, String empName, String department, String designation, double hourlyRate, String joinDate) {
        super(empId, empName, department, designation, hourlyRate * 80, joinDate); // assuming 80 hrs/month approx
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public void addHours(int hours) {
        this.hoursWorked += hours;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class ContractEmployee extends Employee {
    int contractDuration; // in months

    public ContractEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate, int contractDuration) {
        super(empId, empName, department, designation, baseSalary, joinDate);
        this.contractDuration = contractDuration;
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // fixed monthly salary
    }
}

class Department {
    String deptId;
    String deptName;
    Employee manager;
    List<Employee> employees;
    double budget;

    public Department(String deptId, String deptName, Employee manager, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.budget = budget;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public double calculateDepartmentExpense() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary() + e.calculateBonus();
        }
        return total;
    }
}

class CompanyReports {
    public static void calculateCompanyPayroll(List<Employee> employees) {
        double payroll = 0;
        for (Employee e : employees) {
            payroll += e.calculateSalary() + e.calculateBonus();
        }
        System.out.println("\nTotal Company Payroll: " + payroll);
    }

    public static void getDepartmentWiseExpenses(List<Department> departments) {
        System.out.println("\n--- Department Wise Expenses ---");
        for (Department d : departments) {
            System.out.println(d.deptName + ": " + d.calculateDepartmentExpense());
        }
    }

    public static void getAttendanceReport(List<Employee> employees) {
        System.out.println("\n--- Attendance Report ---");
        for (Employee e : employees) {
            int presentDays = 0;
            for (boolean p : e.attendanceRecord) if (p) presentDays++;
            System.out.println(e.empName + " (" + e.designation + "): Present " + presentDays + "/" + Employee.workingDaysPerMonth);
        }
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        FullTimeEmployee e1 = new FullTimeEmployee("E001", "Alice", "IT", "Developer", 60000, "01-01-2023");
        PartTimeEmployee e2 = new PartTimeEmployee("E002", "Bob", "IT", "Support", 500, "05-01-2023");
        ContractEmployee e3 = new ContractEmployee("E003", "Charlie", "HR", "Consultant", 40000, "10-01-2023", 12);

        // Attendance
        for (int i = 1; i <= 28; i++) e1.markAttendance(i, true);
        e1.markAttendance(29, false);
        e1.markAttendance(30, false);

        for (int i = 1; i <= 25; i++) e2.markAttendance(i, true);
        e2.addHours(120);

        for (int i = 1; i <= 30; i++) e3.markAttendance(i, true);

        // Departments
        Department d1 = new Department("D001", "IT", e1, 500000);
        Department d2 = new Department("D002", "HR", e3, 300000);
        d1.addEmployee(e1);
        d1.addEmployee(e2);
        d2.addEmployee(e3);

        // Pay Slips
        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        // Reports
        List<Employee> employees = Arrays.asList(e1, e2, e3);
        List<Department> departments = Arrays.asList(d1, d2);

        CompanyReports.calculateCompanyPayroll(employees);
        CompanyReports.getDepartmentWiseExpenses(departments);
        CompanyReports.getAttendanceReport(employees);
    }
}