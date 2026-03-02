import java.util.Scanner;

class CelsiusToFahrenheit {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Temperature in Celsius: ");
		double celsius = input.nextDouble();
		
		double fahrenheitResult = (celsius * (9.0 / 5.0)) + 32;
		System.out.println("The " + celsius + " Celsius is " + fahrenheitResult + " Fahrenheit.");
		
		input.close();
	}
}