/**
 * MAIN CLASS UseCase11ConcurrentBookingSimulation
 *
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 *
 * Description:
 * Demonstrates how concurrent access to shared resources can lead to inconsistent 
 * system state if not managed, and shows how synchronization ensures correctness 
 * under multi-user conditions.
 *
 * @author Sourav Kumar
 * @version 10.0
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Multiple guests submit booking requests simultaneously.
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Vanmathi", "Double");
        Reservation r3 = new Reservation("Kural", "Suite");
        Reservation r4 = new Reservation("Subha", "Single");

        // Requests are added to a shared booking queue.
        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);
        queue.addRequest(r4);

        // Run processor inside multiple threads to simulate concurrency
        Thread t1 = new Thread(new ConcurrentBookingProcessor(queue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(queue, inventory, allocationService));
        Thread t3 = new Thread(new ConcurrentBookingProcessor(queue, inventory, allocationService));

        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The system completes allocations without conflicts or inconsistencies.
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));
        System.out.println("Double: " + inventory.getAvailableRooms("Double"));
        System.out.println("Suite: " + inventory.getAvailableRooms("Suite"));
    }
}
