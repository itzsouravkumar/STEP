public class Manager extends Employee implements Payable {
    private double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void calculateBonus() {
        bonus = salary * 0.10;
        System.out.println("Bonus for " + name + ": " + bonus);
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip for " + name);
        System.out.println("Base Salary: " + salary);
        System.out.println("Total Pay (with bonus): " + (salary + bonus));
    }
}