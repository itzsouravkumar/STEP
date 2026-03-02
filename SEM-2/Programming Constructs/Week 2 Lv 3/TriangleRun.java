import java.util.Scanner;

class TriangleRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side of the park in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter the second side of the park in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter the third side of the park in meters: ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;
        double rounds = 5000 / perimeter;

        System.out.printf("The total number of rounds the athlete will run is " + rounds + " to complete 5 km.");

        input.close();
    }
}