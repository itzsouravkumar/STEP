import java.util.Random;
import java.util.Scanner;

public class StudentScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.close();

        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores);

        displayScorecard(scores, results);
    }

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random random = new Random();

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = random.nextInt(90) + 10;
            scores[i][1] = random.nextInt(90) + 10;
            scores[i][2] = random.nextInt(90) + 10;
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + scores[i][0]);
            System.out.println("Chemistry: " + scores[i][1]);
            System.out.println("Math: " + scores[i][2]);
            System.out.println("Total Marks: " + results[i][0]);
            System.out.println("Average: " + results[i][1]);
            System.out.println("Percentage: " + results[i][2] + "%");
            System.out.println();
        }
    }
}