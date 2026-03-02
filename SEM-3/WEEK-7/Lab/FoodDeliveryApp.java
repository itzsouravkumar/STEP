public class FoodDeliveryApp {
    public static void main(String[] args) {
        DeliveryCalculator delivery = new DeliveryCalculator();
        delivery.calculateDelivery(10);
        delivery.calculateDelivery(10, 15);
        delivery.calculateDelivery(10, 3);
        delivery.calculateDelivery(10, 20, 50, 60);
    }
}

class DeliveryCalculator {
    public void calculateDelivery(double distance) {
        double cost = distance * 5; 
        System.out.println("Basic Delivery: Distance = " + distance + " km, Cost = $" + cost);
    }

    public void calculateDelivery(double distance, double priorityFee) {
        double cost = distance * 5 + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km, Priority Fee = $" + priorityFee + ", Total Cost = $" + cost);
    }

    public void calculateDelivery(double distance, int numberOfOrders) {
        double cost = distance * 5;
        double discount = numberOfOrders * 2;
        double total = cost - discount;
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + numberOfOrders + ", Discount = $" + discount + ", Total Cost = $" + total);
    }

    public void calculateDelivery(double distance, double discountPercent, double freeDeliveryThreshold, double orderAmount) {
        double cost = distance * 5;
        double discount = (orderAmount * discountPercent) / 100;
        if (orderAmount > freeDeliveryThreshold) cost = 0;
        double total = cost - discount;
        System.out.println("Festival Special: Distance = " + distance + " km, Discount = $" + discount + ", Total Cost = $" + total + (orderAmount > freeDeliveryThreshold ? " (Free Delivery Applied)" : ""));
    }
}