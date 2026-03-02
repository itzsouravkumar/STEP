public class ProductDemo {
    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop");
        Product p2 = new Product("P001", "Laptop Pro");

        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        Product p3 = p1;
        System.out.println("p1 == p3: " + (p1 == p3));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
    }
}

class Product {
    private String productId;
    private String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return productId.equals(other.productId);
    }

    @Override
    public String toString() {
        return "Product[ID: " + productId + ", Name: " + productName + "]";
    }
}