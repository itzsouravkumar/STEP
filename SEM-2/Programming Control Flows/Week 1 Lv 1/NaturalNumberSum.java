import java.util.Scanner;

class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        
        if (num >= 1) {
            int sum = num * (num + 1) / 2;
            System.out.println("The sum of " + num + " natural numbers is " + sum);
        } else {
            System.out.println("The num " + num + " is not a natural number");
        }
        
        input.close();
    }
}