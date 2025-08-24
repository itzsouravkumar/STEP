import java.util.*;
public class emailAnalyzer {

    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1;
    }

    public static String[] extractParts(String email) {
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = email.substring(at + 1, dot);
        String extension = email.substring(dot + 1);
        return new String[]{username, domain, domainName, extension};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();

        System.out.println("Enter emails (type 'done' to finish):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("done")) break;
            emails.add(email);
        }

        int valid = 0, invalid = 0;
        Map<String, Integer> domainCount = new HashMap<>();
        int totalUsernameLength = 0;

        System.out.printf("%-25s %-15s %-15s %-15s %-10s %-10s%n",
                "Email", "Username", "Domain", "Domain Name", "Ext", "Valid");

        for (String email : emails) {
            boolean validEmail = isValidEmail(email);
            if (validEmail) {
                valid++;
                String[] parts = extractParts(email);
                totalUsernameLength += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);
                System.out.printf("%-25s %-15s %-15s %-15s %-10s %-10s%n",
                        email, parts[0], parts[1], parts[2], parts[3], "Yes");
            } else {
                invalid++;
                System.out.printf("%-25s %-15s %-15s %-15s %-10s %-10s%n",
                        email, "-", "-", "-", "-", "No");
            }
        }

        String mostCommonDomain = domainCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("None");

        System.out.println("\nValid: " + valid + ", Invalid: " + invalid);
        System.out.println("Most common domain: " + mostCommonDomain);
        System.out.println("Average username length: " + (valid > 0 ? totalUsernameLength / valid : 0));
        sc.close();
    }
}

