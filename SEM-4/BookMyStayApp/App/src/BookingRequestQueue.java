import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        this.queue = new LinkedList<>();
    }

    public void addRequest(Reservation request) {
        queue.offer(request);
    }

    public Reservation processNextRequest() {
        return queue.poll();
    }

    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }
}
