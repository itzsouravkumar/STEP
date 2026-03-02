import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance or invalid withdrawal");
    }

    public double checkBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------------");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[5];
        int count = 0;

        accounts[count++] = new BankAccount("Alice", 1000);
        accounts[count++] = new BankAccount("Bob", 500);
        accounts[count++] = new BankAccount("Charlie", 2000);

        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[2].withdraw(3000);

        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
        }

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}