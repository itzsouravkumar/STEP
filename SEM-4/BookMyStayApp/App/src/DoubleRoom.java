public class DoubleRoom extends Room {
    private boolean hasAC;

    public DoubleRoom(int roomNumber, double price, boolean hasAC) {
        super(roomNumber, "Double", price);
        this.hasAC = hasAC;
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType 
                + ", Price: $" + price + ", AC: " + (hasAC ? "Yes" : "No"));
    }
}
