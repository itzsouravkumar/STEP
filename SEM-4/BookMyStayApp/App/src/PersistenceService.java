import java.io.*;

/**
 * Handles storing and retrieving system state from persistent storage.
 */
public class PersistenceService {
    private static final String FILE_NAME = "system_state.dat";

    /**
     * Serializes current booking and inventory state into a persistent format.
     */
    public void saveState(RoomInventory inventory, BookingHistory history) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            oos.writeObject(history);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     * Attempts to load inventory state from the persistent file.
     * Returns a new instance if file is not found or corrupted.
     */
    public RoomInventory loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (RoomInventory) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No valid inventory data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory data. Starting fresh.");
        }
        return new RoomInventory();
    }

    /**
     * Attempts to load booking history from the persistent file.
     * Assumes loadInventory was called first, ensuring same fallback.
     */
    public BookingHistory loadHistory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ois.readObject(); // Skip inventory
            return (BookingHistory) ois.readObject();
        } catch (Exception e) {
            return new BookingHistory();
        }
    }
}
