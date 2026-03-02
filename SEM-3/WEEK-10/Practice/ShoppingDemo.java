import java.util.*;

public class ShoppingDemo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Amit", "amit@gmail.com");

        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 25000);
        Product product3 = new Product("Mouse", 800);

        Order order1 = new Order("O101");
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order("O102");
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        customer1.showCustomerOrders();
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }

    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public String getOrderId() {
        return orderId;
    }

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order " + orderId + " contains:");
        for (Product p : products) {
            p.showDetails();
        }
    }
}

class Customer {
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order " + order.getOrderId());
    }

    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}
