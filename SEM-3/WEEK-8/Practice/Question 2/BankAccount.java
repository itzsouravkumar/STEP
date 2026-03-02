public abstract class BankAccount {
    protected double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }
    public abstract void calculateInterest();
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}