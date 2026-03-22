/**
 * Validator class to validate booking input and system constraints.
 */
public class InvalidBookingValidator {

    /**
     * Validate the given guest name and room type.
     * Throws InvalidBookingException if validation fails.
     */
    public void validate(String guestName, String roomType) throws InvalidBookingException {
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room types before processing bookings
        if (!"Single".equalsIgnoreCase(roomType) && 
            !"Double".equalsIgnoreCase(roomType) && 
            !"Suite".equalsIgnoreCase(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}
