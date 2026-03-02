import java.time.LocalDateTime;
import java.util.*;


public class ProductMain {
    public static void main(String[] args) {
        Product phone = Product.createElectronics("P1", "Smartphone", "TechCorp", 500, 0.5, new String[]{"5G", "128GB"}, Map.of("Color", "Black"));
        Product tshirt = Product.createClothing("C1", "T-Shirt", "ClothInc", 20, 0.2, new String[]{"Cotton"}, Map.of("Size", "M"));

        Customer cust = new Customer("CUST1", "john@example.com", "John", "1234567890", "English", "2021-01-01");

        ShoppingCart cart = new ShoppingCart("CART1", cust.getCustomerId());
        cart.addItem(phone, 1);
        cart.addItem(tshirt, 3);

        Order order = new Order("O1");
        PaymentProcessor pay = new PaymentProcessor("PAY1", "SEC123");
        ShippingCalculator ship = new ShippingCalculator(Map.of("US", 5.0, "EU", 8.0));

        ECommerceSystem.addToCatalog("P1", phone);
        ECommerceSystem.addToCatalog("C1", tshirt);

        System.out.println(cust.getPublicProfile());
        System.out.println(cart);
        System.out.println(order);
        System.out.println(pay.processPayment(560));
        System.out.println("Shipping: " + ship.calculateShipping("US", phone.getWeight() + tshirt.getWeight()));
        System.out.println("Order processed: " + ECommerceSystem.processOrder(order, cust));
    }
}

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String id, String n, String c, String m, double p, double w, String[] f, Map<String, String> s) {
        if (id == null || n == null || c == null || m == null || p < 0 || w < 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        this.productId = id;
        this.name = n;
        this.category = c;
        this.manufacturer = m;
        this.basePrice = p;
        this.weight = w;
        this.features = f == null ? new String[0] : f.clone();
        this.specifications = s == null ? new HashMap<>() : new HashMap<>(s);
    }

    public static Product createElectronics(String id, String n, String m, double p, double w, String[] f, Map<String, String> s) {
        return new Product(id, n, "Electronics", m, p, w, f, s);
    }

    public static Product createClothing(String id, String n, String m, double p, double w, String[] f, Map<String, String> s) {
        return new Product(id, n, "Clothing", m, p, w, f, s);
    }

    public static Product createBooks(String id, String n, String m, double p, double w, String[] f, Map<String, String> s) {
        return new Product(id, n, "Books", m, p, w, f, s);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        if ("US".equalsIgnoreCase(region)) return basePrice * 0.07;
        if ("EU".equalsIgnoreCase(region)) return basePrice * 0.20;
        return basePrice * 0.10;
    }

    public String toString() {
        return name + " (" + category + ") - " + basePrice;
    }

    public int hashCode() { return Objects.hash(productId); }
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return productId.equals(p.productId);
    }
}

class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;

    public Customer(String id, String e, String n, String p, String lang, String date) {
        if (id == null || e == null || date == null) throw new IllegalArgumentException("Invalid customer data");
        this.customerId = id;
        this.email = e;
        this.name = n;
        this.phoneNumber = p;
        this.preferredLanguage = lang;
        this.accountCreationDate = date;
    }

    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPreferredLanguage() { return preferredLanguage; }
    public String getAccountCreationDate() { return accountCreationDate; }

    public void setName(String n) { this.name = n; }
    public void setPhoneNumber(String p) { this.phoneNumber = p; }
    public void setPreferredLanguage(String l) { this.preferredLanguage = l; }

    String getCreditRating() { return "Good"; }

    public String getPublicProfile() { return "Customer: " + name + ", Language: " + preferredLanguage; }

    public String toString() { return "Customer: " + name + " (" + email + ")"; }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private List<Object> items;
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String id, String custId) {
        this.cartId = id;
        this.customerId = custId;
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        this.itemCount = 0;
    }

    public boolean addItem(Object product, int quantity) {
        if (!(product instanceof Product) || quantity <= 0) return false;
        Product p = (Product) product;
        for (int i = 0; i < quantity; i++) items.add(p);
        itemCount += quantity;
        totalAmount += p.getBasePrice() * quantity - calculateDiscount();
        return true;
    }

    private double calculateDiscount() {
        if (itemCount > 5) return totalAmount * 0.05;
        return 0;
    }

    String getCartSummary() {
        return "Cart " + cartId + " for customer " + customerId + ": " + itemCount + " items, Total = " + totalAmount;
    }

    public String toString() { return getCartSummary(); }
}

class Order {
    private final String orderId;
    private final LocalDateTime orderTime;

    public Order(String id) {
        this.orderId = id;
        this.orderTime = LocalDateTime.now();
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }

    public String toString() { return "Order " + orderId + " placed at " + orderTime; }
}

class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String id, String key) {
        this.processorId = id;
        this.securityKey = key;
    }

    public String getProcessorId() { return processorId; }

    public String processPayment(double amount) { return "Processed " + amount + " via " + processorId; }

    public String toString() { return "PaymentProcessor: " + processorId; }
}

class ShippingCalculator {
    private final Map<String, Double> shippingRates;

    public ShippingCalculator(Map<String, Double> rates) {
        this.shippingRates = new HashMap<>(rates);
    }

    public double calculateShipping(String region, double weight) {
        return shippingRates.getOrDefault(region, 10.0) * weight;
    }

    public String toString() { return "ShippingCalculator with rates: " + shippingRates; }
}

final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        return order instanceof Order && customer instanceof Customer;
    }

    public static void addToCatalog(String key, Object product) {
        productCatalog.put(key, product);
    }

    public static Object getFromCatalog(String key) {
        return productCatalog.get(key);
    }
}