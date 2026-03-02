package Practice;
public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(), new WalletPayment() };

        for (Payment p : payments) {
            System.out.println("Class: " + p.getClass().getSimpleName());
            p.pay();
        }
    }
}

class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via Credit Card");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via Wallet");
    }
}

