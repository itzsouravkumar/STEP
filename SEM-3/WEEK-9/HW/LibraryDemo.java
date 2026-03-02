import java.util.ArrayList;
import java.util.List;

public class LibraryDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("1984", "George Orwell");

        Library original = new Library();
        original.addBook(b1);
        original.addBook(b2);

        Library shallowCopy = original.shallowClone();
        Library deepCopy = original.deepClone();

        System.out.println("Original Library: " + original);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);

        shallowCopy.getBooks().get(0).setTitle("The Pilgrimage");
        deepCopy.getBooks().get(1).setTitle("Animal Farm");

        System.out.println("\nAfter modifying copies:");
        System.out.println("Original Library: " + original);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
    }
}

class Book implements Cloneable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class Library implements Cloneable {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) this.clone();
    }

    public Library deepClone() throws CloneNotSupportedException {
        Library copy = (Library) this.clone();
        List<Book> copiedBooks = new ArrayList<>();
        for (Book b : this.books) {
            copiedBooks.add((Book) b.clone());
        }
        copy.books = copiedBooks;
        return copy;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return books.toString();
    }
}