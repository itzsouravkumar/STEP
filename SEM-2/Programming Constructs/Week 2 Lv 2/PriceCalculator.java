import java.util.Scanner;

class PriceCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the unit price in INR:");
		double unitPrice = input.nextDouble();
		
		System.out.println("Enter the quantity:");
		double quantity = input.nextDouble();
		
		double totalPrice = unitPrice * quantity;

		System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice + ".");
		
		input.close();
	}
}