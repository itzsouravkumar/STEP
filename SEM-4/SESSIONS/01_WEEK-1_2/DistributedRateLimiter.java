import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TokenBucket {
    private int tokens;
    private long lastRefillTime;
    private final int maxTokens;
    private final int refillRate; // Tokens per second (approx)
    private final long windowMillis;

    public TokenBucket(int maxTokens, long windowMillis) {
        this.maxTokens = maxTokens;
        this.windowMillis = windowMillis;
        this.tokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
        this.refillRate = (int)(maxTokens / (windowMillis / 1000));
    }

    public synchronized boolean allowRequest() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTime;
        
        if (elapsedTime > windowMillis) {
            tokens = maxTokens;
            lastRefillTime = now;
        } else {
            // Refill smoothly
            int tokensToAdd = (int) ((elapsedTime / 1000.0) * refillRate);
            if (tokensToAdd > 0) {
                tokens = Math.min(maxTokens, tokens + tokensToAdd);
                lastRefillTime = now; // Only update if we added tokens
            }
        }
    }
    
    public synchronized int getRemainingTokens() {
        refill();
        return tokens;
    }
}

public class DistributedRateLimiter {
    private final Map<String, TokenBucket> clientBuckets;
    private final int maxRequests;
    private final long windowDuration;
    
    public DistributedRateLimiter() {
        this.clientBuckets = new ConcurrentHashMap<>();
        this.maxRequests = 1000;
        this.windowDuration = 3600 * 1000; // 1 hour in ms
    }

    public String checkRateLimit(String clientId) {
        long startTime = System.nanoTime();
        TokenBucket bucket = clientBuckets.computeIfAbsent(clientId, k -> new TokenBucket(maxRequests, windowDuration));
        
        boolean allowed = bucket.allowRequest();
        long responseTime = (System.nanoTime() - startTime) / 1000000; // ms
        
        if (allowed) {
            return "Allowed (" + bucket.getRemainingTokens() + " requests remaining)";
        } else {
            return "Denied (0 requests remaining, retry later)";
        }
    }

    public String getRateLimitStatus(String clientId) {
        TokenBucket bucket = clientBuckets.get(clientId);
        if (bucket == null) {
            return "Client not found";
        }
        int used = maxRequests - bucket.getRemainingTokens();
        long reset = System.currentTimeMillis() / 1000 + 3600; 
        return "{used: " + used + ", limit: " + maxRequests + ", reset: " + reset + "}";
    }

    public static void main(String[] args) {
        DistributedRateLimiter limiter = new DistributedRateLimiter();
        System.out.println("checkRateLimit(clientId=\"abc123\") -> " + limiter.checkRateLimit("abc123"));
        System.out.println("checkRateLimit(clientId=\"abc123\") -> " + limiter.checkRateLimit("abc123"));
        
        for (int i = 0; i < 998; i++) {
            limiter.checkRateLimit("abc123");
        }
        
        System.out.println("checkRateLimit(clientId=\"abc123\") -> " + limiter.checkRateLimit("abc123"));
        System.out.println("getRateLimitStatus(\"abc123\") -> " + limiter.getRateLimitStatus("abc123"));
    }
}
