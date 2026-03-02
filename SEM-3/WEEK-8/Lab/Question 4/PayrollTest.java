public class PayrollTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Ayush", 60000);
        manager.calculateBonus();
        manager.generatePaySlip();
    }
}