import java.util.*;

class Book {
    String bookId;
    String title;
    String author;
    String isbn;
    String category;
    boolean isIssued;
    String issueDate;
    String dueDate;
    int issueCount;

    static int totalBooks = 0;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
        this.issueCount = 0;
        totalBooks++;
    }

    public void displayBookInfo() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + category + " | Issued: " + isIssued);
    }
}

class Member {
    String memberId;
    String memberName;
    String memberType;
    Book[] booksIssued;
    int bookCount;
    double totalFines;
    String membershipDate;

    static int totalMembers = 0;
    static String libraryName = "City Library";
    static double finePerDay = 2.0;
    static int maxBooksAllowed = 3;

    public Member(String memberId, String memberName, String memberType, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new Book[maxBooksAllowed];
        this.bookCount = 0;
        this.totalFines = 0.0;
        totalMembers++;
    }

    public void issueBook(Book book, String issueDate, String dueDate) {
        if (bookCount >= maxBooksAllowed) {
            System.out.println("Cannot issue more than " + maxBooksAllowed + " books.");
            return;
        }
        if (!book.isIssued) {
            booksIssued[bookCount++] = book;
            book.isIssued = true;
            book.issueDate = issueDate;
            book.dueDate = dueDate;
            book.issueCount++;
            System.out.println("Book issued: " + book.title + " to " + memberName);
        } else {
            System.out.println("Book already issued.");
        }
    }

    public void returnBook(String bookId, String returnDate) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i] != null && booksIssued[i].bookId.equals(bookId)) {
                Book book = booksIssued[i];
                double fine = calculateFine(book.dueDate, returnDate);
                totalFines += fine;
                book.isIssued = false;
                book.issueDate = "";
                book.dueDate = "";
                booksIssued[i] = null;
                System.out.println("Book returned: " + book.title + ". Fine: " + fine);
                return;
            }
        }
        System.out.println("Book not found in issued list.");
    }

    public void renewBook(String bookId, String newDueDate) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i] != null && booksIssued[i].bookId.equals(bookId)) {
                booksIssued[i].dueDate = newDueDate;
                System.out.println("Book renewed: " + booksIssued[i].title + " till " + newDueDate);
                return;
            }
        }
        System.out.println("Book not found to renew.");
    }

    private double calculateFine(String dueDate, String returnDate) {
        try {
            String[] d1 = dueDate.split("-");
            String[] d2 = returnDate.split("-");
            int dd1 = Integer.parseInt(d1[0]);
            int dd2 = Integer.parseInt(d2[0]);
            int mm1 = Integer.parseInt(d1[1]);
            int mm2 = Integer.parseInt(d2[1]);
            int yy1 = Integer.parseInt(d1[2]);
            int yy2 = Integer.parseInt(d2[2]);
            int days = (yy2 - yy1) * 365 + (mm2 - mm1) * 30 + (dd2 - dd1);
            return days > 0 ? days * finePerDay : 0.0;
        } catch (Exception e) {
            return 0.0;
        }
    }

    public void searchBooks(Book[] books, String keyword) {
        System.out.println("Search results for: " + keyword);
        for (Book b : books) {
            if (b != null && (b.title.contains(keyword) || b.author.contains(keyword))) {
                b.displayBookInfo();
            }
        }
    }

    public void reserveBook(Book book) {
        if (!book.isIssued) {
            System.out.println("Book is available. You can issue it directly.");
        } else {
            System.out.println("Book is currently issued. Reservation placed for " + memberName);
        }
    }

    public static void generateLibraryReport(Book[] books, Member[] members) {
        System.out.println("\n--- Library Report ---");
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + Book.totalBooks);
        System.out.println("Total Members: " + totalMembers);
        System.out.println("Overdue Books: " + getOverdueBooks(books).size());
        System.out.println("Most Popular Books: ");
        for (Book b : getMostPopularBooks(books)) {
            System.out.println(b.title + " (Issued " + b.issueCount + " times)");
        }
    }

    public static List<Book> getOverdueBooks(Book[] books) {
        List<Book> overdue = new ArrayList<>();
        for (Book b : books) {
            if (b != null && b.isIssued) {
                overdue.add(b);
            }
        }
        return overdue;
    }

    public static List<Book> getMostPopularBooks(Book[] books) {
        List<Book> list = Arrays.asList(books);
        list.sort((a, b) -> b.issueCount - a.issueCount);
        return list.subList(0, Math.min(3, list.size()));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Java Basics", "James", "ISBN001", "Programming");
        Book b2 = new Book("B002", "Data Structures", "Mark", "ISBN002", "CS");
        Book b3 = new Book("B003", "Algorithms", "John", "ISBN003", "CS");
        Book[] books = {b1, b2, b3};

        Member m1 = new Member("M001", "Alice", "Student", "01-01-2024");
        Member m2 = new Member("M002", "Bob", "Faculty", "05-01-2024");
        Member[] members = {m1, m2};

        m1.issueBook(b1, "01-02-2024", "10-02-2024");
        m1.issueBook(b2, "01-02-2024", "10-02-2024");

        m1.returnBook("B1", "15-02-2024"); // wrong ID test
        m1.returnBook("B001", "15-02-2024"); // late return → fine

        m2.issueBook(b3, "02-02-2024", "12-02-2024");
        m2.renewBook("B003", "20-02-2024");

        m1.searchBooks(books, "Data");

        Member.generateLibraryReport(books, members);
    }
}