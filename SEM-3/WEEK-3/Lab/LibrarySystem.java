class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.bookId = generateBookId();
        totalBooks++;
        availableBooks++;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
        } else {
            System.out.println("Book already issued!");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
        System.out.println("----------------------------");
    }

    private static String generateBookId() {
        return "B" + String.format("%03d", totalBooks + 1);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int totalMembers = 0;

    public Member(String name, int maxBooks) {
        this.memberName = name;
        this.memberId = generateMemberId();
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
        totalMembers++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < booksIssued.length) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
            System.out.println(memberName + " borrowed: " + book.getBookId());
        } else {
            System.out.println("Cannot borrow book. Either not available or limit reached.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b != null && b.getBookId().equals(bookId)) {
                        b.returnBook();
                        System.out.println(memberName + " returned: " + bookId);
                        booksIssued[i] = booksIssued[bookCount - 1];
                        booksIssued[bookCount - 1] = null;
                        bookCount--;
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Book not found in member's issued list!");
        }
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.print("Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        if (bookCount == 0) System.out.print("None");
        System.out.println("\n----------------------------");
    }

    private static String generateMemberId() {
        return "M" + String.format("%03d", totalMembers + 1);
    }

    public static int getTotalMembers() {
        return totalMembers;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        Member[] members = new Member[3];

        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Python Guide", "Guido van Rossum");
        books[2] = new Book("C++ Mastery", "Bjarne Stroustrup");

        members[0] = new Member("Alice", 3);
        members[1] = new Member("Bob", 2);

        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[1]);
        members[0].borrowBook(books[2]);

        members[0].returnBook("B001", books);

        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            if (b != null) b.displayBookInfo();
        }

        System.out.println("--- Members ---");
        for (Member m : members) {
            if (m != null) m.displayMemberInfo();
        }

        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
        System.out.println("Total Members: " + Member.getTotalMembers());
    }
}