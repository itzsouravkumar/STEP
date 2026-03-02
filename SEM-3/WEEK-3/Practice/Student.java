public class Student {
    // TODO: Define private instance variables
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // TODO: Create a default constructor (no parameters)
    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    // TODO: Create a parameterized constructor that accepts all attributes
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // TODO: Create getter and setter methods for all attributes
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // TODO: Create a method calculateLetterGrade()
    public String calculateLetterGrade() {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // TODO: Create a method displayStudent() that shows all information
    public void displayStudent() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Course: " + course + ", Grade: " + grade + " (" + calculateLetterGrade() + ")");
    }

    public static void main(String[] args) {
        // TODO: Create one student using default constructor, then set values
        Student s1 = new Student();
        s1.setStudentId("S001");
        s1.setName("Alice");
        s1.setGrade(85.5);
        s1.setCourse("Mathematics");

        // TODO: Create another student using parameterized constructor
        Student s2 = new Student("S002", "Bob", 72.0, "Physics");

        // TODO: Demonstrate all getter/setter methods
        System.out.println("Before update: " + s1.getName() + " - " + s1.getCourse());
        s1.setCourse("Computer Science");
        System.out.println("After update: " + s1.getName() + " - " + s1.getCourse());

        // TODO: Show both students' information and letter grades
        s1.displayStudent();
        s2.displayStudent();
    }
}