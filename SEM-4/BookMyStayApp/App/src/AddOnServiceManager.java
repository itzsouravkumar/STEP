import java.util.*;

/**
 * CLASS - AddOnServiceManager
 * Use Case 7: Add-On Service Selection
 */
public class AddOnServiceManager {

    // Map<ReservationID, List of Services>
    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {

        // If no list exists → create one
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());

        // Add service
        servicesByReservation.get(reservationId).add(service);
    }

    // Calculate total cost
    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }

        return total;
    }
}