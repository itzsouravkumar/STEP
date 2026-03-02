public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway creditCard = new CreditCardPayment();
        creditCard.pay(1500.00);
        creditCard.refund(500.00);

        System.out.println();

        PaymentGateway upi = new UPIPayment();
        upi.pay(800.00);
        upi.refund(200.00);
    }
}