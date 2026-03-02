import java.util.Scanner;

class SwapNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("The swapped numbers are " + num1 + " and " + num2 + ".");

        input.close();
    }
}