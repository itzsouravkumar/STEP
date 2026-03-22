import java.io.Serializable;

public class Reservation implements Serializable {
    private String guestName;
    private String roomType;
    private String reservationId; // New Field for UC-6/7

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // New Getter (Required by UseCase7)
    public String getReservationId() {
        return reservationId;
    }

    // New Setter (Used by RoomAllocationService)
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room Type: " + roomType + ", ID: " + reservationId;
    }
}