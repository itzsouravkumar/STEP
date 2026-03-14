/**
 * MAIN CLASS UseCase6RoomAllocationService
 * 
 * Use Case 6: Reservation Confirmation & Room Allocation
 * 
 * Description:
 * This class demonstrates how booking requests are confirmed and rooms 
 * are allocated safely. It consumes booking requests in FIFO order and 
 * updates inventory immediately.
 * 
 * @author Sourav Kumar
 * @version 6.0
 */
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        
        allocationService.processQueue(bookingQueue, inventory);
    }
}
