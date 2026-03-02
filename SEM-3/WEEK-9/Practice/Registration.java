package Practice;
public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo contact = new ContactInfo("alice@example.com", "1234567890");
        Student s1 = new Student("S001", "Alice", contact);

        Student shallow = s1.shallowCopy();
        Student deep = s1.deepCopy();

        System.out.println("Original: " + s1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);

        shallow.contact.email = "shallow@example.com";
        deep.contact.phone = "0987654321";

        System.out.println("\nAfter modifying copies:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);
    }
}

class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Student shallowCopy() throws CloneNotSupportedException {
        return (Student) this.clone();
    }

    public Student deepCopy() throws CloneNotSupportedException {
        Student copy = (Student) this.clone();
        copy.contact = (ContactInfo) this.contact.clone();
        return copy;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Contact: [" + contact + "]";
    }
}
