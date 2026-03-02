import java.util.Scanner;

class QuotientRemainder {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number 1:");
		int num1 = input.nextInt();
		
		System.out.println("Enter the number 2:");
		int num2 = input.nextInt();
		
		int quotient = num1 / num2;
		int remainder = num1 % num2;

		System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two numbers " + num1 + " and " + num2 + ".");
		
		input.close();
	}
}