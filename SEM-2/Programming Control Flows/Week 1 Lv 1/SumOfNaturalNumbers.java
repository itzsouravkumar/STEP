import java.util.Scanner;

class SumOfNaturalNumbers {
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
        int i = 1;
        while (i <= n) {
            loopSum += i;
            i++;
        }

        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Sum using while loop: " + loopSum);

        if (formulaSum == loopSum) {
            System.out.println("Both results are correct.");
        } else {
            System.out.println("The results are not equal.");
        }
		
		input.close();
    }
}