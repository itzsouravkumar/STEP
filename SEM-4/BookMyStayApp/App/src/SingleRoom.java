public class SingleRoom extends Room {
    private boolean hasAC;

    public SingleRoom(int roomNumber, double price, boolean hasAC) {
        super(roomNumber, "Single", price);
        this.hasAC = hasAC;
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType 
                + ", Price: $" + price + ", AC: " + (hasAC ? "Yes" : "No"));
    }
}
