/**
 * MAIN CLASS UseCase12DataPersistenceRecovery
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * Introduces persistence and recovery concepts by ensuring that critical system 
 * state survives application restarts securely.
 *
 * @author Sourav Kumar
 * @version 11.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {
        System.out.println("System Recovery");

        PersistenceService persistenceService = new PersistenceService();

        // System restarts. Persisted data is loaded from the file.
        // Inventory and booking state are restored into memory.
        RoomInventory inventory = persistenceService.loadInventory();
        BookingHistory history = persistenceService.loadHistory();

        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailableRooms("Single"));
        System.out.println("Double: " + inventory.getAvailableRooms("Double"));
        System.out.println("Suite: " + inventory.getAvailableRooms("Suite"));

        // System prepares for shutdown.
        // Current booking and inventory state is serialized into a persistent format.
        persistenceService.saveState(inventory, history);
    }
}
