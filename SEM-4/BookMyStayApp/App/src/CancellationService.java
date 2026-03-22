import java.util.Stack;

/**
 * Service to handle booking cancellations and system rollbacks.
 */
public class CancellationService {
    
    // A Stack is used to track recently released room IDs. Let's use it for reservation IDs.
    private Stack<String> rollbackHistory;

    public CancellationService() {
        this.rollbackHistory = new Stack<>();
    }

    /**
     * Validates cancellation, releases room, and updates rollback state.
     */
    public void cancelBooking(Reservation reservation, RoomInventory inventory) {
        if (reservation == null || reservation.getReservationId() == null) {
            System.out.println("Invalid reservation for cancellation.");
            return;
        }
        
        // The allocated room ID (or reservation ID) is recorded in a rollback structure.
        rollbackHistory.push(reservation.getReservationId());
        
        // Inventory count for the corresponding room type is incremented.
        inventory.releaseRoom(reservation.getRoomType());
        
        // Print success
        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + reservation.getRoomType());
    }

    /**
     * Prints the rollback history in LIFO order.
     */
    public void printRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (int i = rollbackHistory.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackHistory.get(i));
        }
    }
}
