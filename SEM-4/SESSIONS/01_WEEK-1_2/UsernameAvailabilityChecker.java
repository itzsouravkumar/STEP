import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class UsernameAvailabilityChecker {
    private Map<String, Integer> usernameToUserId;
    private Map<String, Integer> usernameAttempts;

    public UsernameAvailabilityChecker() {
        this.usernameToUserId = new HashMap<>();
        this.usernameAttempts = new HashMap<>();
    }

    public boolean checkAvailability(String username) {
        usernameAttempts.put(username, usernameAttempts.getOrDefault(username, 0) + 1);
        return !usernameToUserId.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        if (!usernameToUserId.containsKey(username)) {
            usernameToUserId.put(username, userId);
        } else {
            throw new IllegalArgumentException("Username already taken: " + username);
        }
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        int i = 1;
        while (suggestions.size() < 3) {
            String suggestion1 = username + i;
            if (!usernameToUserId.containsKey(suggestion1)) {
                suggestions.add(suggestion1);
            }
            if (suggestions.size() < 3) {
                String suggestion2 = username.replace("_", ".") + i;
                if (!usernameToUserId.containsKey(suggestion2) && !suggestion2.equals(suggestion1)) {
                    suggestions.add(suggestion2);
                }
            }
            i++;
        }
        return suggestions;
    }

    public String getMostAttempted() {
        String mostAttempted = null;
        int maxAttempts = -1;
        for (Map.Entry<String, Integer> entry : usernameAttempts.entrySet()) {
            if (entry.getValue() > maxAttempts) {
                maxAttempts = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }
        if (mostAttempted == null) return "No attempts yet";
        return mostAttempted + " (" + maxAttempts + " attempts)";
    }

    public static void main(String[] args) {
        UsernameAvailabilityChecker checker = new UsernameAvailabilityChecker();
        checker.registerUser("john_doe", 1);
        checker.registerUser("admin", 2);

        System.out.println("checkAvailability(\"john_doe\") -> " + checker.checkAvailability("john_doe"));
        System.out.println("checkAvailability(\"jane_smith\") -> " + checker.checkAvailability("jane_smith"));
        System.out.println("suggestAlternatives(\"john_doe\") -> " + checker.suggestAlternatives("john_doe"));

        for(int i=0; i<10543; i++){
            checker.checkAvailability("admin");
        }
        System.out.println("getMostAttempted() -> " + checker.getMostAttempted());
    }
}
