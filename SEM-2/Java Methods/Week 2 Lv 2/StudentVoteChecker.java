import java.util.Scanner;

public class StudentVoteChecker {
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }

        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];

        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();

            if (canStudentVote(studentAges[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                if (studentAges[i] < 0) {
                    System.out.println("Invalid age entered for student " + (i + 1) + ". Age cannot be negative.");
                } else {
                    System.out.println("Student " + (i + 1) + " cannot vote.");
                }
            }
        }
		
		scanner.close();
    }
}