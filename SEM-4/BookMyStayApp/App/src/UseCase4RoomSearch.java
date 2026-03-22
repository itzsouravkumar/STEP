/**
 * MAIN CLASS UseCase4RoomSearch
 * 
 * Use Case 4: Room Search & Availability Check
 * 
 * Description:
 * This class demonstrates searching for available rooms and details without 
 * modifying system state. It reinforces safe data access and clear separation 
 * of responsibilities.
 * 
 * @author Sourav Kumar
 * @version 4.0
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
         System.out.println("Initializing Hotel Booking System...");
         System.out.println("--------------------------------------------------");

         // Initialization
         Room singleRoom = new SingleRoom(101, 100.0, true);
         Room doubleRoom = new DoubleRoom(102, 150.0, true);
         Room suiteRoom = new SuiteRoom(103, 300.0, true);
         Room[] rooms = { singleRoom, doubleRoom, suiteRoom };

         RoomInventory inventory = new RoomInventory();
         SearchService searchService = new SearchService();
         
         System.out.println("Guest initiates a room search...");
         searchService.searchAvailableRooms(inventory, rooms);
         
         System.out.println("Simulating a situation where Suite becomes fully booked...");
         inventory.updateAvailability("Suite", -2); // Since 2 is the initial count in RoomInventory
         
         System.out.println("Guest initiates another search...");
         searchService.searchAvailableRooms(inventory, rooms);
         
         System.out.println("System state remains unchanged during search operations.");
         System.out.println("--------------------------------------------------");
    }
}
