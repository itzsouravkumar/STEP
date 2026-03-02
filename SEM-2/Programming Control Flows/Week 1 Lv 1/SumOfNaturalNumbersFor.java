import java.util.Scanner;

class SumOfNaturalNumbersFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Enter a natural number: ");
        n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
            return;
        }

        int formulaSum = n * (n + 1) / 2;

        int loopSum = 0;
        for (int i = 1; i <= n; i++) {
            loopSum += i;
        }

        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Sum using for loop: " + loopSum);

        if (formulaSum == loopSum) {
            System.out.println("Both results are correct.");
        } else {
            System.out.println("The results are not equal.");
        }
		
		input.close();
    }
}