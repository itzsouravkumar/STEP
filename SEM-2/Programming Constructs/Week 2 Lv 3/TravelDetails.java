import java.util.Scanner;

class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter the starting city: ");
        String fromCity = input.nextLine();

        System.out.println("Enter the via city: ");
        String viaCity = input.nextLine();

        System.out.println("Enter the destination city: ");
        String toCity = input.nextLine();

        System.out.println("Enter the distance from " + fromCity + " to " + viaCity + ":");
        double fromToVia = input.nextDouble();

        System.out.println("Enter the distance from " + viaCity + " to " + toCity + ":");
        double viaToFinalCity = input.nextDouble();

        System.out.println("Enter the total time taken: ");
        double timeTaken = input.nextDouble();
		
		double totalDistance = fromToVia + viaToFinalCity;
		
		System.out.println("Name: " + name);
		System.out.println("Starting City: " + fromCity);
		System.out.println("Via City: " + viaCity);
		System.out.println("Destination City: " + toCity);
		System.out.println("Distance from Starting City to Via City: " + fromToVia);
		System.out.println("Distance from Via City to Destination City: " + viaToFinalCity);
		System.out.println("Total Time Taken: " + timeTaken);
		System.out.println("Total Distance from Starting City to Destination City: " + totalDistance);

        input.close();
    }
}