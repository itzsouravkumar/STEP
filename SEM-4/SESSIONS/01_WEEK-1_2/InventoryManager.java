import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManager {
    private Map<String, AtomicInteger> stockLevels;
    private Map<String, Queue<Integer>> waitingLists;

    public InventoryManager() {
        stockLevels = new ConcurrentHashMap<>();
        waitingLists = new ConcurrentHashMap<>();
    }

    public void addProduct(String productId, int initialStock) {
        stockLevels.put(productId, new AtomicInteger(initialStock));
        waitingLists.put(productId, new LinkedList<>());
    }

    public String checkStock(String productId) {
        AtomicInteger stock = stockLevels.get(productId);
        if (stock != null) {
            return stock.get() + " units available";
        }
        return "Product not found";
    }

    public synchronized String purchaseItem(String productId, int userId) {
        AtomicInteger stock = stockLevels.get(productId);
        if (stock == null) {
            return "Product not found";
        }

        if (stock.get() > 0) {
            int remaining = stock.decrementAndGet();
            return "Success, " + remaining + " units remaining";
        } else {
            Queue<Integer> waitingList = waitingLists.get(productId);
            waitingList.offer(userId);
            return "Added to waiting list, position #" + waitingList.size();
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct("IPHONE15_256GB", 100);

        System.out.println("checkStock(\"IPHONE15_256GB\") -> " + manager.checkStock("IPHONE15_256GB"));
        System.out.println("purchaseItem(\"IPHONE15_256GB\", 12345) -> " + manager.purchaseItem("IPHONE15_256GB", 12345));
        System.out.println("purchaseItem(\"IPHONE15_256GB\", 67890) -> " + manager.purchaseItem("IPHONE15_256GB", 67890));

        // Simulate 98 more purchases to empty stock
        for (int i = 0; i < 98; i++) {
            manager.purchaseItem("IPHONE15_256GB", 1000 + i);
        }

        System.out.println("purchaseItem(\"IPHONE15_256GB\", 99999) -> " + manager.purchaseItem("IPHONE15_256GB", 99999));
    }
}
