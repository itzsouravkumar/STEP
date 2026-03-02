public class ATMDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", 10000, 1234);
        ATM atm = new ATM(account);
        Customer customer = new Customer("Ravi", atm);

        customer.performWithdrawal(1234, 3000);
        customer.performWithdrawal(1111, 2000);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class ATM {
    private BankAccount linkedAccount;

    public ATM(BankAccount linkedAccount) {
        this.linkedAccount = linkedAccount;
    }

    public void withdraw(int enteredPin, double amount) {
        System.out.println("Verifying PIN...");
        if (linkedAccount.validatePin(enteredPin)) {
            System.out.println("PIN verified successfully.");
            linkedAccount.debit(amount);
            System.out.println("Transaction successful. Dispensing cash...");
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Invalid PIN. Transaction failed.");
        }
    }
}

class Customer {
    private String name;
    private ATM atm;

    public Customer(String name, ATM atm) {
        this.name = name;
        this.atm = atm;
    }

    public void performWithdrawal(int pin, double amount) {
        System.out.println(name + " is requesting withdrawal of ₹" + amount + "...");
        atm.withdraw(pin, amount);
        System.out.println(name + " received confirmation.\n");
    }
}
