public class CloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("New York", "5th Avenue");
        Person p1 = new Person("John", addr);

        Person shallow = p1.shallowCopy();
        Person deep = p1.deepCopy();

        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);

        shallow.address.city = "Los Angeles";
        deep.address.street = "Sunset Blvd";

        System.out.println("\nAfter modifying copies:");
        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);
    }
}

class Address implements Cloneable {
    String city;
    String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return street + ", " + city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person shallowCopy() throws CloneNotSupportedException {
        return (Person) this.clone();
    }

    public Person deepCopy() throws CloneNotSupportedException {
        Person copy = (Person) this.clone();
        copy.address = new Address(address.city, address.street);
        return copy;
    }

    @Override
    public String toString() {
        return name + " [" + address + "]";
    }
}