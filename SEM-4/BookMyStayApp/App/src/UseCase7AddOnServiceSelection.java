/**
 * MAIN CLASS UseCase7AddOnServiceSelection
 *
 * Use Case 7: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class extends the booking model to support optional services.
 * It demonstrates business extensibility by mapping additional services
 * to confirmed reservations without modifying the core inventory logic.
 *
 * @author Sourav Kumar
 * @version 6.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Reuse UC-6 logic
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");

        bookingQueue.addRequest(r1);

        allocationService.processQueue(bookingQueue, inventory);

        String reservationId = r1.getReservationId();

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        AddOnService spa = new AddOnService("Spa", 1000);
        AddOnService breakfast = new AddOnService("Breakfast", 500);

        // Attach services
        serviceManager.addService(reservationId, spa);
        serviceManager.addService(reservationId, breakfast);

        // Calculate total
        double totalCost = serviceManager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}