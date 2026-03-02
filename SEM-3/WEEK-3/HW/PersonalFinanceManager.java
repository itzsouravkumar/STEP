class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts = 0;
    private static String bankName;
    private static int counter = 1;

    public PersonalAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialDeposit;
        this.totalIncome = initialDeposit;
        this.totalExpenses = 0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid income amount.");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent: " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid or insufficient balance for expense.");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("===== Account Summary =====");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
        System.out.println("===========================\n");
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", counter++);
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class PersonalFinanceManager {
    public static void main(String[] args) {
        PersonalAccount.setBankName("FutureBank");

        PersonalAccount a1 = new PersonalAccount("Alice", 5000);
        PersonalAccount a2 = new PersonalAccount("Bob", 10000);
        PersonalAccount a3 = new PersonalAccount("Charlie", 7000);

        a1.addIncome(2000, "Salary");
        a1.addExpense(1500, "Groceries");
        a1.addExpense(1000, "Rent");

        a2.addIncome(5000, "Freelance Work");
        a2.addExpense(2000, "Travel");

        a3.addIncome(3000, "Bonus");
        a3.addExpense(500, "Shopping");

        a1.displayAccountSummary();
        a2.displayAccountSummary();
        a3.displayAccountSummary();

        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
    }
}