import java.util.Scanner;

class DistanceCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the distance in feet:");
		double distanceInFeet = input.nextDouble();

		double distanceInYards = distanceInFeet / 3;
		double distanceInMiles = distanceInFeet / 5280;

		System.out.println("Distance in yards: " + distanceInYards + ".");
		System.out.println("Distance in miles: " + distanceInMiles + ".");
		
		input.close();
	}
}