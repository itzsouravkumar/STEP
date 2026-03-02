import java.util.Scanner;

class Calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number 1:");
		double num1 = input.nextDouble();
		
		System.out.println("Enter the number 2:");
		double num2 = input.nextDouble();
		
		double add = num1 + num2;
		double subtract = num1 - num2;
		double multiply = num1 * num2;
		double divide = num1 / num2;
		
		System.out.println("Addition of " + num1 + " and " + num2 + " is " + add + ".");
		System.out.println("Subtraction of " + num2 + " from " + num1 + " is " + subtract + ".");
		System.out.println("Multiplication of " + num1 + " and " + num2 + " is " + multiply + ".");
		System.out.println("Division of " + num1 + " and " + num2 + " is " + divide + ".");
		
		input.close();
	}
}