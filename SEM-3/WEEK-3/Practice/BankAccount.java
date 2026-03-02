public class BankAccount {
    // TODO: Create static variables
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // TODO: Create instance variables
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // TODO: Create constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // count of all accounts
    }

    // TODO: Create static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts + ", Interest Rate: " + interestRate + "%");
    }

    // TODO: Create instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void displayAccountInfo() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance + ", Interest Earned: " + calculateInterest());
    }

    public static void main(String[] args) {
        // TODO: Set bank name and interest rate using static methods
        BankAccount.setBankName("Global Bank");
        BankAccount.setInterestRate(5.0);

        // TODO: Create multiple BankAccount objects
        BankAccount acc1 = new BankAccount("A001", "Alice", 1000);
        BankAccount acc2 = new BankAccount("A002", "Bob", 2000);

        // TODO: Show that static members are shared across all objects
        BankAccount.displayBankInfo();

        // TODO: Show that instance members are unique to each object
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        // Demonstrating deposits and withdrawals
        acc1.deposit(500);
        acc2.withdraw(1000);

        // TODO: Demonstrate calling static methods with and without objects
        BankAccount.displayBankInfo(); // via class
        acc1.displayBankInfo();        // via object (not recommended but possible)
    }
}