import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {
    // HashMap to map room types to their available counts
    private Map<String, Integer> availabilityMap;

    public RoomInventory() {
        availabilityMap = new HashMap<>();
        // Initializing room availability for each room type
        availabilityMap.put("Single", 5);
        availabilityMap.put("Double", 3);
        availabilityMap.put("Suite", 2);
    }

    public void updateAvailability(String roomType, int count) {
        if (availabilityMap.containsKey(roomType)) {
            availabilityMap.put(roomType, availabilityMap.get(roomType) + count);
        } else {
            System.out.println("Room type '" + roomType + "' does not exist.");
        }
    }

    public void releaseRoom(String roomType) {
        if (availabilityMap.containsKey(roomType)) {
            availabilityMap.put(roomType, availabilityMap.get(roomType) + 1);
        }
    }

    public int getAvailableRooms(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : availabilityMap.entrySet()) {
            System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
        }
    }
}
