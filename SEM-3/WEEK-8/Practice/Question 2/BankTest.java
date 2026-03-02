public class BankTest {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(10000);
        acc1.displayBalance();
        acc1.calculateInterest();

        BankAccount acc2 = new CurrentAccount(10000);
        acc2.displayBalance();
        acc2.calculateInterest();
    }
}