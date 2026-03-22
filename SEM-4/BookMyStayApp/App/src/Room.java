public abstract class Room {
    protected int roomNumber;
    protected String roomType;
    protected double price;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + ", Price: $" + price);
    }
}
