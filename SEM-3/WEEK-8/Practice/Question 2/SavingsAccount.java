public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }
    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest: " + interest);
    }
}