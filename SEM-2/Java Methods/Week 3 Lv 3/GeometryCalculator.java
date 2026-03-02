import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        scanner.close();

        System.out.println("Euclidean Distance: " + findEuclideanDistance(x1, y1, x2, y2));

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of line: y = " + lineEquation[0] + "x + " + lineEquation[1]);
    }

    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] equation = new double[2];

        if (x1 == x2) {
            System.out.println("Vertical line! Slope is undefined.");
            equation[0] = Double.POSITIVE_INFINITY;
            equation[1] = Double.POSITIVE_INFINITY;
        } else {
            equation[0] = (y2 - y1) / (x2 - x1);
            equation[1] = y1 - equation[0] * x1;
        }

        return equation;
    }
}