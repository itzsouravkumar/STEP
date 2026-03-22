import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the historical records of bookings.
 */
public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    /**
     * Store each confirmed reservation in booking history.
     */
    public void addRecord(Reservation reservation) {
        history.add(reservation);
    }

    /**
     * Retrieve stored reservations for review.
     */
    public List<Reservation> getHistory() {
        return history;
    }
}
