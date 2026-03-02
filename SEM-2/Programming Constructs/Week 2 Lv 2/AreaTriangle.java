import java.util.Scanner;

class AreaTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the base in cm:");
		double base = input.nextDouble();
		
		System.out.println("Enter the height in cm:");
		double height = input.nextDouble();
		
		double areaInSqCm = (0.5) * base * height;
		double areaInSqIn = areaInSqCm * 0.155;

		System.out.println("Area of Triangle in square centimeters is " + areaInSqCm + ".");
		System.out.println("Area of Triangle in square inches is " + areaInSqIn + ".");
		
		input.close();
	}
}