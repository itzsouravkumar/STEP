/**
 * MAIN CLASS UseCase5BookingRequestQueue
 * 
 * Use Case 5: Booking Request (First-Come-First-Served)
 * 
 * Description:
 * This class demonstrates handling multiple booking requests fairly by introducing 
 * a request intake mechanism that preserves arrival order, reflecting real-world 
 * booking behavior during peak demand.
 * 
 * @author Sourav Kumar
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");
        
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        
        while (bookingQueue.hasPendingRequests()) {
            Reservation request = bookingQueue.processNextRequest();
            System.out.println("Processing booking for " + request);
        }
    }
}
