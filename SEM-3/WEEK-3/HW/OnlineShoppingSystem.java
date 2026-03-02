import java.util.Scanner;

class Product {
    String productId;
    String productName;
    double price;
    String category;
    int stockQuantity;

    static int totalProducts = 0;
    static String[] categories = {"Electronics", "Clothing", "Groceries"};

    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static void getProductsByCategory(Product[] products, String category) {
        System.out.println("Products in category: " + category);
        for (Product p : products) {
            if (p != null && p.category.equalsIgnoreCase(category)) {
                System.out.println(p.productId + " - " + p.productName + " | Price: " + p.price + " | Stock: " + p.stockQuantity);
            }
        }
    }
}

class ShoppingCart {
    String cartId;
    String customerName;
    Product[] products;
    int[] quantities;
    double cartTotal;
    int itemCount;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[10];
        this.quantities = new int[10];
        this.cartTotal = 0;
        this.itemCount = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.stockQuantity >= quantity) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.stockQuantity -= quantity;
            itemCount++;
            calculateTotal();
            System.out.println(quantity + " x " + product.productName + " added to cart.");
        } else {
            System.out.println("Insufficient stock for " + product.productName);
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i] != null && products[i].productId.equals(productId)) {
                products[i].stockQuantity += quantities[i]; // return stock
                System.out.println("Removed " + products[i].productName + " from cart.");
                // shift items
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].price * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("\n===== Shopping Cart for " + customerName + " =====");
        if (itemCount == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(products[i].productName + " | Qty: " + quantities[i] + " | Price: " + products[i].price);
            }
            System.out.println("Cart Total: " + cartTotal);
        }
        System.out.println("============================\n");
    }

    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cart is empty. Cannot checkout.");
        } else {
            displayCart();
            System.out.println("Checkout complete. Thank you for shopping!");
            itemCount = 0;
            cartTotal = 0;
        }
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product("P001", "Laptop", 50000, "Electronics", 5),
            new Product("P002", "T-Shirt", 800, "Clothing", 20),
            new Product("P003", "Rice Bag", 1200, "Groceries", 15),
            new Product("P004", "Headphones", 2000, "Electronics", 10)
        };

        ShoppingCart cart = new ShoppingCart("C001", "John Doe");

        int choice;
        do {
            System.out.println("\n=== Online Shopping Menu ===");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAll Products:");
                    for (Product p : products) {
                        System.out.println(p.productId + " - " + p.productName + " | Price: " + p.price + " | Stock: " + p.stockQuantity);
                    }
                    break;
                case 2:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    Product.getProductsByCategory(products, category);
                    break;
                case 3:
                    System.out.print("Enter Product ID to add: ");
                    String pid = sc.nextLine();
                    Product prod = Product.findProductById(products, pid);
                    if (prod != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();
                        cart.addProduct(prod, qty);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String rid = sc.nextLine();
                    cart.removeProduct(rid);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}