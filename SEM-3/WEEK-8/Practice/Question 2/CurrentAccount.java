public class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }
    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: " + interest);
    }
}
