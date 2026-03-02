import java.util.Scanner;

public class TriangleParkRun {
    public static int computeRounds(double side1, double side2, double side3, double totalDistance) {
        double perimeter = side1 + side2 + side3;

        return (int) (totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double totalDistance = 5000;

        int rounds = computeRounds(side1, side2, side3, totalDistance);

        System.out.println("The athlete needs to complete " + rounds + " rounds to run a total of 5 km.");

        scanner.close();
    }
}