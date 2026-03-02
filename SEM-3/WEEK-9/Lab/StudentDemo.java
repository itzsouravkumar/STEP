import java.util.HashSet;
import java.util.Objects;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("S001", "Alice");
        Student s2 = new Student("S002", "Bob");
        Student s3 = new Student("S001", "Alice Smith");

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println("Students in HashSet:");
        for (Student s : set) {
            System.out.println(s);
        }
    }
}

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student[ID: " + id + ", Name: " + name + "]";
    }
}