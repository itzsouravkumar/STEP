public class LibrarySystem {
    public static void main(String[] args) {
        LibraryUser[] users = new LibraryUser[3];

        users[0] = new Student("Alice", "S101");
        users[1] = new Faculty("Dr. Bob", "F202");
        users[2] = new Guest("Charlie", "G303");

        for (LibraryUser user : users) {
            user.enterLibrary();
            user.displayInfo();
            System.out.println();
        }

        ((Student)users[0]).borrowBooks();
        ((Student)users[0]).accessComputers();
        ((Faculty)users[1]).reserveBooks();
        ((Faculty)users[1]).accessResearchDatabases();
        ((Guest)users[2]).browseBooks();
    }
}

class LibraryUser {
    protected String name;
    protected String id;

    public LibraryUser(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void enterLibrary() {
        System.out.println(name + " has entered the library.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Student extends LibraryUser {
    public Student(String name, String id) {
        super(name, id);
    }

    public void borrowBooks() {
        System.out.println(name + " is borrowing books.");
    }

    public void accessComputers() {
        System.out.println(name + " is accessing computers.");
    }
}

class Faculty extends LibraryUser {
    public Faculty(String name, String id) {
        super(name, id);
    }

    public void reserveBooks() {
        System.out.println(name + " is reserving books.");
    }

    public void accessResearchDatabases() {
        System.out.println(name + " is accessing research databases.");
    }
}

class Guest extends LibraryUser {
    public Guest(String name, String id) {
        super(name, id);
    }

    public void browseBooks() {
        System.out.println(name + " is browsing books.");
    }
}