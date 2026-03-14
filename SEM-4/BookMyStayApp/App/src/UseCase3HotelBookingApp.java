/**
 * MAIN CLASS UseCase3HotelBookingApp
 * 
 * Use Case 3: Centralized Room Inventory Management
 * 
 * Description:
 * This class demonstrates centralized inventory management by replacing scattered 
 * availability variables with a single, consistent data structure using HashMap.
 * 
 * @author Sourav Kumar
 * @version 3.0
 */
public class UseCase3HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Initializing Hotel Booking System...");
        System.out.println("--------------------------------------------------");

        // Room Initialization
        Room singleRoom = new SingleRoom(101, 100.0, true);
        Room doubleRoom = new DoubleRoom(102, 150.0, true);
        Room suiteRoom = new SuiteRoom(103, 300.0, true);
        
        System.out.println("Sample Room Details:");
        singleRoom.displayDetails();
        doubleRoom.displayDetails();
        suiteRoom.displayDetails();
        System.out.println("--------------------------------------------------");

        // Centralized Inventory Management
        RoomInventory inventory = new RoomInventory();
        
        System.out.println("Initial Inventory State:");
        inventory.displayInventory();
        System.out.println("--------------------------------------------------");

        System.out.println("Updating availability to simulate a booking (1 Single Room booked)...");
        inventory.updateAvailability("Single", -1);
        
        System.out.println("Inventory State After Booking:");
        inventory.displayInventory();
        System.out.println("--------------------------------------------------");
        
        System.out.println("System Initialization and Inventory Check Complete.");
    }
}
