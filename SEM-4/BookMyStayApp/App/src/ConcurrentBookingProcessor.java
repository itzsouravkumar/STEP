/**
 * Processes booking requests in a multi-threaded environment.
 * Ensures thread-safe polling from the queue and synchronized allocation.
 */
public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue queue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue queue, RoomInventory inventory, RoomAllocationService allocationService) {
        this.queue = queue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (true) {
            Reservation request = null;

            // Threads retrieve requests using synchronized access.
            synchronized (queue) {
                if (queue.hasPendingRequests()) {
                    request = queue.processNextRequest();
                } else {
                    break;
                }
            }

            // Room allocation and inventory updates are performed inside critical sections (via synchronized allocate)
            if (request != null) {
                allocationService.allocate(request, inventory);
            }
        }
    }
}
