import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {
    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService() {
        allocatedRooms = new HashMap<>();
    }

    public void processQueue(BookingRequestQueue queue, RoomInventory inventory) {
        System.out.println("Room Allocation Processing");
        while (queue.hasPendingRequests()) {
            Reservation request = queue.processNextRequest();
            String roomType = request.getRoomType();
            
            if (inventory.getAvailableRooms(roomType) > 0) {
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                Set<String> assignedIds = allocatedRooms.get(roomType);
                
                int roomIdNumber = assignedIds.size() + 1;
                String roomId = roomType + "-" + roomIdNumber;
                
                assignedIds.add(roomId);
                inventory.updateAvailability(roomType, -1);
                
                System.out.println("Booking confirmed for Guest: " + request.getGuestName() + ", Room ID: " + roomId);
            }
        }
    }
}
