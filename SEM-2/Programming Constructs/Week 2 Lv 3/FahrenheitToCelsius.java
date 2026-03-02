import java.util.Scanner;

class FahrenheitToCelsius {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Temperature in Fahrenheit: ");
		double fahrenheit = input.nextDouble();
		
		double celsiusResult = (fahrenheit - 32) * (5.0 / 9.0);
		System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius.");
		
		input.close();
	}
}