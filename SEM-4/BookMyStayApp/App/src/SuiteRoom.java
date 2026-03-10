public class SuiteRoom extends Room {
    private boolean hasLivingArea;

    public SuiteRoom(int roomNumber, double price, boolean hasLivingArea) {
        super(roomNumber, "Suite", price);
        this.hasLivingArea = hasLivingArea;
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType 
                + ", Price: $" + price + ", Living Area: " + (hasLivingArea ? "Yes" : "No"));
    }
}
