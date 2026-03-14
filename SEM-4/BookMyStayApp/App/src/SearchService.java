public class SearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {
        System.out.println("--- Available Rooms ---");
        boolean found = false;
        for (Room room : rooms) {
            int availableCount = inventory.getAvailableRooms(room.getRoomType());
            if (availableCount > 0) {
                System.out.print("Available: " + availableCount + " | ");
                room.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available.");
        }
        System.out.println("-----------------------");
    }
}
