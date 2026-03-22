/**
 * MAIN CLASS UseCase8BookingHistoryReport
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class introduces historical tracking of confirmed bookings to provide
 * operational visibility, enable audits, and support reporting.
 *
 * @author Sourav Kumar
 * @version 7.0
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {
        
        BookingHistory bookingHistory = new BookingHistory();

        // Create reservations
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // A booking is successfully confirmed.
        // The confirmed reservation is added to booking history.
        // Booking history maintains records in insertion order.
        bookingHistory.addRecord(r1);
        bookingHistory.addRecord(r2);
        bookingHistory.addRecord(r3);

        // Admin requests booking information or reports.
        BookingReportService reportService = new BookingReportService();
        
        // Stored reservations are retrieved and displayed as required.
        reportService.generateReport(bookingHistory);
    }
}
