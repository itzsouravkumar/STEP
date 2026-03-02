import java.util.Scanner;

public class SumOfNaturalNumbers {
	public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int num = input.nextInt();

        if (num < 1) {
            System.out.println("The input number is not a natural number.");
            System.exit(0);
        }

        int recursiveSum = sumUsingRecursion(num);

        int formulaSum = sumUsingFormula(num);

        System.out.println("Sum of first " + num + " natural numbers using recursion: " + recursiveSum);
        System.out.println("Sum of first " + num + " natural numbers using formula: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both methods produce the same result.");
        } else {
            System.out.println("Both methods do not produce the same result");
        }
    }
}