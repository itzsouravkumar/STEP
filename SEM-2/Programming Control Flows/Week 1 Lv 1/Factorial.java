import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        
        System.out.print("Enter a positive integer: ");
        num = input.nextInt();
        
        if (num < 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        
        int factorial = 1;
        int i = 1;
        
        while (i <= num) {
            factorial *= i;
            i++;
        }
        
        System.out.println("The factorial of " + num + " is: " + factorial);
		
		input.close();
    }
}