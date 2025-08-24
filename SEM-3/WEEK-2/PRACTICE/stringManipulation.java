import java.util.*;
public class stringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 1. trim()
        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        // 2. replace()
        String replaced = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced: " + replaced);

        // 3. replaceAll() → remove digits
        String noDigits = replaced.replaceAll("\\d", "");
        System.out.println("No digits: " + noDigits);

        // 4. split()
        String[] words = noDigits.split("_");
        System.out.println("Words: " + Arrays.toString(words));

        // 5. join()
        String joined = String.join(" | ", words);
        System.out.println("Joined: " + joined);

        // Extra Methods
        System.out.println("No punctuation: " + removePunctuation(input));
        System.out.println("Capitalized: " + capitalizeWords(input));
        System.out.println("Reversed Order: " + reverseWordOrder(input));
        countWordFrequency(input);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }
        System.out.println("Word Frequency: " + freq);
    }
}
