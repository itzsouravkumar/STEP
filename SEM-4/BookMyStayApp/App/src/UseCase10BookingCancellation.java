/**
 * MAIN CLASS UseCase10BookingCancellation
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * Enables safe cancellation of confirmed bookings by correctly reversing
 * system state changes, ensuring inventory consistency.
 *
 * @author Sourav Kumar
 * @version 9.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Guest initiates a cancellation request for an existing booking.
        Reservation r1 = new Reservation("John", "Single");
        r1.setReservationId("Single-1"); // Assume this was generated previously

        // Cancel the booking
        cancellationService.cancelBooking(r1, inventory);

        // Display history
        cancellationService.printRollbackHistory();

        // Prove inventory restoration
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailableRooms("Single"));
    }
}
