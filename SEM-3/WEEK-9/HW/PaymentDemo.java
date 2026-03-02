public class PaymentDemo {
    public static void main(String[] args) {
        Payment payment = new Payment(1500);
        payment.processTransaction();
    }
}

interface Discount {
    double apply(double amount);
}

class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void processTransaction() {
        class Validator {
            public boolean isValid() {
                return amount > 0;
            }
        }

        Validator validator = new Validator();
        if (!validator.isValid()) {
            System.out.println("Invalid payment amount!");
            return;
        }

        Discount discount = new Discount() {
            @Override
            public double apply(double amt) {
                return amt * 0.9; // 10% discount
            }
        };

        double finalAmount = discount.apply(amount);
        System.out.println("Original amount: $" + amount);
        System.out.println("Amount after discount: $" + finalAmount);
        System.out.println("Transaction processed successfully!");
    }
}