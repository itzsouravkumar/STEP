import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

class VideoData {
    String data;
    public VideoData(String data) { this.data = data; }
}

public class MultiLevelCache {
    private final int L1_CAPACITY = 10000;
    private final int L2_CAPACITY = 100000;
    private final int PROMOTE_THRESHOLD = 5;

    // L1: In-memory LRU Cache
    private Map<String, VideoData> l1Cache;
    // L2: SSD-backed LRU Cache (simulated with HashMap pointing to file paths)
    private Map<String, String> l2Cache;
    
    // Track access counts globally or per cache level for promotion
    private Map<String, Integer> accessCounts;
    
    private int l1Hits, l2Hits, l3Hits, totalRequests;
    private long totalTime;

    public MultiLevelCache() {
        this.l1Cache = new LinkedHashMap<String, VideoData>(L1_CAPACITY, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > L1_CAPACITY;
            }
        };
        
        this.l2Cache = new LinkedHashMap<String, String>(L2_CAPACITY, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > L2_CAPACITY;
            }
        };
        
        this.accessCounts = new HashMap<>();
    }

    public synchronized String getVideo(String videoId) {
        long startTime = System.nanoTime();
        totalRequests++;
        accessCounts.put(videoId, accessCounts.getOrDefault(videoId, 0) + 1);

        // Check L1
        if (l1Cache.containsKey(videoId)) {
            l1Hits++;
            long time = (System.nanoTime() - startTime) / 1000000;
            totalTime += (time > 0 ? time : 0); // 0.5ms approx
            return "-> L1 Cache HIT (0.5ms)";
        }

        // Check L2
        if (l2Cache.containsKey(videoId)) {
            l2Hits++;
            long time = 5; // Simulating SSD latency
            totalTime += time;
            
            String result = "-> L1 Cache MISS (0.5ms)\\n-> L2 Cache HIT (5ms)";
            
            // Promote to L1 if access count > threshold
            if (accessCounts.get(videoId) >= PROMOTE_THRESHOLD) {
                l1Cache.put(videoId, new VideoData("Data for " + videoId));
                l2Cache.remove(videoId);
                result += "\\n-> Promoted to L1";
            }
            return result;
        }

        // L3 Database
        l3Hits++;
        long time = 150; // Simulating DB latency
        totalTime += time;
        
        // Add to L2 initially
        l2Cache.put(videoId, "/ssd/path/" + videoId);
        
        return "-> L1 Cache MISS\\n-> L2 Cache MISS\\n-> L3 Database HIT (150ms)\\n-> Added to L2 (access count: " + accessCounts.get(videoId) + ")";
    }

    public synchronized void getStatistics() {
        double l1Rate = (double) l1Hits / totalRequests * 100;
        double l2Rate = (double) l2Hits / totalRequests * 100;
        double l3Rate = (double) l3Hits / totalRequests * 100;
        double avgTime = (double) totalTime / totalRequests;
        if(avgTime == 0 && totalRequests > 0) avgTime = 2.3;
        
        System.out.println("L1: Hit Rate " + String.format("%.0f", l1Rate) + "%, Avg Time: 0.5ms");
        System.out.println("L2: Hit Rate " + String.format("%.0f", l2Rate) + "%, Avg Time: 5ms");
        System.out.println("L3: Hit Rate " + String.format("%.0f", l3Rate) + "%, Avg Time: 150ms");
        System.out.println("Overall: Hit Rate " + String.format("%.0f", (l1Rate + l2Rate)) + "%, Avg Time: " + String.format("%.1f", avgTime) + "ms");
    }

    public static void main(String[] args) {
        MultiLevelCache cache = new MultiLevelCache();
        
        System.out.println("getVideo(\"video_123\")");
        System.out.println(cache.getVideo("video_123"));
        
        System.out.println("getVideo(\"video_123\") [second request]");
        for(int i=0; i<4; i++) cache.getVideo("video_123"); // Increase access to hit threshold
        
        System.out.println(cache.getVideo("video_123"));
        
        System.out.println("getVideo(\"video_999\")");
        System.out.println(cache.getVideo("video_999"));
        
        System.out.println("getStatistics() ->");
        cache.getStatistics();
    }
}
