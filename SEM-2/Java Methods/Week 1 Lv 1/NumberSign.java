import java.util.Scanner;

public class NumberSign {
    public static int getSign(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        int sign = getSign(number);
        
        if (sign == 1) {
            System.out.println("The number " + number + " is positive.");
        } else if (sign == -1) {
            System.out.println("The number " + number + " is negative.");
        } else {
            System.out.println("The number " + number + " is zero.");
        }
        
        scanner.close();
    }
}