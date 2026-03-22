import java.util.Scanner;

/**
 * MAIN CLASS UseCase9ErrorHandlingValidation
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class introduces structured validation and error handling to detect
 * and handle invalid inputs and inconsistent states early.
 *
 * @author Sourav Kumar
 * @version 8.0
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvalidBookingValidator validator = new InvalidBookingValidator();

        System.out.println("Booking Validation");
        
        System.out.print("Enter guest name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.nextLine();

        try {
            // Validates input values and system constraints
            validator.validate(name, roomType);
            
            // If validation passes, process the request (not explicitly shown in snapshot logic, but safe to continue)
            
        } catch (InvalidBookingException e) {
            // A meaningful failure message is displayed.
            System.out.println("Booking failed: " + e.getMessage());
        }
        
        // Ensure system remains stable after errors.
        scanner.close();
    }
}
