/**
 * Custom exception to represent invalid booking scenarios.
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
