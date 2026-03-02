public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("The Alchemist", "Paulo Coelho");

        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2));

        Book b3 = b1;
        System.out.println("b1 == b3: " + (b1 == b3));
        System.out.println("b1.equals(b3): " + b1.equals(b3));
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }

    @Override
    public String toString() {
        return "Book[Title: " + title + ", Author: " + author + "]";
    }
}