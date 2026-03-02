import java.util.Scanner;

class SquarePerimeter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the perimeter of the square:");
		double perimeter = input.nextDouble();
		
		double side = perimeter / 4;

		System.out.println("The length of the side is " + side + ".");
		
		input.close();
	}
}