import java.util.Scanner;

class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int originalNum = num;
        int sum = 0;

        while (originalNum != 0) {
            int digit = originalNum % 10;
            sum += digit;
            originalNum /= 10;
        }

        if (num % sum == 0) {
            System.out.println(num + " is a Harshad Number.");
        } else {
            System.out.println(num + " is Not a Harshad Number.");
        }

        input.close();
    }
}