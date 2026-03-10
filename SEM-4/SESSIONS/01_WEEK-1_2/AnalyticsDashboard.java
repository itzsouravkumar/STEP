import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class PageEvent {
    String url;
    String userId;
    String source;

    public PageEvent(String url, String userId, String source) {
        this.url = url;
        this.userId = userId;
        this.source = source;
    }
}

public class AnalyticsDashboard {
    private Map<String, AtomicInteger> pageViews;
    private Map<String, Set<String>> uniqueVisitors;
    private Map<String, AtomicInteger> trafficSources;
    private int totalViews;

    public AnalyticsDashboard() {
        this.pageViews = new ConcurrentHashMap<>();
        this.uniqueVisitors = new ConcurrentHashMap<>();
        this.trafficSources = new ConcurrentHashMap<>();
        this.totalViews = 0;
    }

    public synchronized void processEvent(PageEvent event) {
        pageViews.computeIfAbsent(event.url, k -> new AtomicInteger(0)).incrementAndGet();
        uniqueVisitors.computeIfAbsent(event.url, k -> ConcurrentHashMap.newKeySet()).add(event.userId);
        trafficSources.computeIfAbsent(event.source, k -> new AtomicInteger(0)).incrementAndGet();
        totalViews++;
    }

    public synchronized void getDashboard() {
        System.out.println("Top Pages:");
        PriorityQueue<Map.Entry<String, AtomicInteger>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue().get() - a.getValue().get()
        );
        pq.addAll(pageViews.entrySet());

        int rank = 1;
        while (!pq.isEmpty() && rank <= 10) {
            Map.Entry<String, AtomicInteger> entry = pq.poll();
            String url = entry.getKey();
            int views = entry.getValue().get();
            int uniques = uniqueVisitors.get(url).size();
            System.out.println(rank + ". " + url + " - " + views + " views (" + uniques + " unique)");
            rank++;
        }

        System.out.println("\nTraffic Sources:");
        for (Map.Entry<String, AtomicInteger> entry : trafficSources.entrySet()) {
            double percentage = (double) entry.getValue().get() / totalViews * 100;
            System.out.printf("%s: %.0f%%, ", entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), percentage);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AnalyticsDashboard dashboard = new AnalyticsDashboard();
        dashboard.processEvent(new PageEvent("/article/breaking-news", "user_123", "google"));
        dashboard.processEvent(new PageEvent("/article/breaking-news", "user_456", "facebook"));
        dashboard.processEvent(new PageEvent("/sports/championship", "user_789", "direct"));
        dashboard.processEvent(new PageEvent("/sports/championship", "user_123", "direct"));
        dashboard.processEvent(new PageEvent("/sports/championship", "user_101", "direct"));
        dashboard.processEvent(new PageEvent("/article/breaking-news", "user_123", "google")); // returning user

        System.out.println("getDashboard() ->");
        dashboard.getDashboard();
    }
}
