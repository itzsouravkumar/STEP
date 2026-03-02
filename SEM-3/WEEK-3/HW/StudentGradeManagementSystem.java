import java.util.*;

class Subject {
    String subjectCode;
    String subjectName;
    int credits;
    String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }
}

class Student {
    String studentId;
    String studentName;
    String className;
    String[] subjects;
    double[][] marks; // [exams][subjects]
    double gpa;

    static int totalStudents = 0;
    static String schoolName = "Default School";
    static String[] gradingScale = {"A: ≥90", "B: 80-89", "C: 70-79", "D: 60-69", "F: <60"};
    static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[3][subjects.length]; // assume 3 exams
        this.gpa = 0;
        totalStudents++;
    }

    public void addMarks(String subject, double marksValue, int examIndex) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                marks[examIndex][i] = marksValue;
                return;
            }
        }
        System.out.println("Subject not found for student " + studentName);
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (double[] exam : marks) {
            for (double m : exam) {
                total += m;
                count++;
            }
        }
        double percentage = total / count;
        if (percentage >= 90) gpa = 4.0;
        else if (percentage >= 80) gpa = 3.0;
        else if (percentage >= 70) gpa = 2.0;
        else if (percentage >= 60) gpa = 1.0;
        else gpa = 0.0;
    }

    public boolean checkPromotionEligibility() {
        double total = 0;
        int count = 0;
        for (double[] exam : marks) {
            for (double m : exam) {
                total += m;
                count++;
            }
        }
        double percentage = total / count;
        return percentage >= passPercentage;
    }

    public void generateReportCard() {
        calculateGPA();
        System.out.println("\n--- Report Card ---");
        System.out.println("Student: " + studentName + " (" + studentId + ")");
        System.out.println("Class: " + className);
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i] + " Marks: ");
            for (int j = 0; j < marks.length; j++) {
                System.out.print(marks[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("GPA: " + gpa);
        System.out.println("Promotion Status: " + (checkPromotionEligibility() ? "Eligible" : "Not Eligible"));
    }

    public static void setGradingScale(String[] newScale) {
        gradingScale = newScale;
    }

    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null) {
                for (double[] exam : s.marks) {
                    for (double m : exam) {
                        total += m;
                        count++;
                    }
                }
            }
        }
        return count > 0 ? total / count : 0;
    }

    public static Student[] getTopPerformers(Student[] students, int count) {
        Arrays.sort(students, (a, b) -> Double.compare(b.gpa, a.gpa));
        return Arrays.copyOfRange(students, 0, Math.min(count, students.length));
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n=== School Report: " + schoolName + " ===");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average: " + calculateClassAverage(students));
        System.out.println("Grading Scale: " + Arrays.toString(gradingScale));
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};
        Student s1 = new Student("S001", "Alice", "10A", subjects);
        Student s2 = new Student("S002", "Bob", "10A", subjects);
        Student s3 = new Student("S003", "Charlie", "10B", subjects);

        s1.addMarks("Math", 95, 0);
        s1.addMarks("Science", 88, 0);
        s1.addMarks("English", 92, 0);

        s2.addMarks("Math", 75, 0);
        s2.addMarks("Science", 82, 0);
        s2.addMarks("English", 70, 0);

        s3.addMarks("Math", 60, 0);
        s3.addMarks("Science", 55, 0);
        s3.addMarks("English", 65, 0);

        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        Student[] allStudents = {s1, s2, s3};

        Student.generateSchoolReport(allStudents);
        System.out.println("\n--- Top Performers ---");
        Student[] toppers = Student.getTopPerformers(allStudents, 2);
        for (Student s : toppers) {
            System.out.println(s.studentName + " | GPA: " + s.gpa);
        }
    }
}