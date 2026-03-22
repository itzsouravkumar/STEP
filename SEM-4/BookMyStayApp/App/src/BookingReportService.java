import java.util.List;

/**
 * Service to generate summaries and reports from booking history.
 */
public class BookingReportService {

    /**
     * Generate summary reports from booking history.
     */
    public void generateReport(BookingHistory bookingHistory) {
        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");
        
        List<Reservation> history = bookingHistory.getHistory();
        for (Reservation reservation : history) {
            System.out.println("Guest: " + reservation.getGuestName() + ", Room Type: " + reservation.getRoomType());
        }
    }
}
