public class Book {
    String title;
    String author;
    double price;

    // TODO: Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // TODO: Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // TODO: Display method
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        // TODO: Create book1 using default constructor
        Book book1 = new Book();

        // TODO: Create book2 using parameterized constructor
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 499.99);

        // TODO: Display both books
        book1.display();
        book2.display();
    }
}
