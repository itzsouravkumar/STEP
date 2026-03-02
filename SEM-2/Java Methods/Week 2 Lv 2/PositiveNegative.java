import java.util.Scanner;

public class PositiveNegative {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + numbers[i] + " is ");
            if (isPositive(numbers[i])) {
                System.out.print("positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println("negative.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[4]);
        System.out.print("The first number (" + numbers[0] + ") is ");
        if (comparisonResult > 0) {
            System.out.println("greater than the last number (" + numbers[4] + ").");
        } else if (comparisonResult < 0) {
            System.out.println("less than the last number (" + numbers[4] + ").");
        } else {
            System.out.println("equal to the last number (" + numbers[4] + ").");
        }
		
		scanner.close();
    }
}