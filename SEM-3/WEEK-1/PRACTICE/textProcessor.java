import java.util.Scanner;
import java.util.Arrays;


public class textProcessor {
    // Method to clean and validate input i.e, remove extra spaces, convert to proper case
    public static String cleanInput(String input) {
        // Trim leading and trailing spaces and convert to proper case
            input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder cleanedInput = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) { //ChatGPT -> Not understood
                cleanedInput.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        return cleanedInput.toString().trim();
    }

    // Method to analyze text
    public static void analyzeText(String text) {
        // Count words, sentences & characters
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replace(" ", "").length(); 

        //Longest word, most common character
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        char mostCommonChar = ' ';
        int maxCount = 0;
        int[] charFrequency = new int[256]; // ASCII size
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                charFrequency[Character.toLowerCase(c)]++;
                if (charFrequency[Character.toLowerCase(c)] > maxCount) {
                    maxCount = charFrequency[Character.toLowerCase(c)];
                    mostCommonChar = Character.toLowerCase(c);
                }
            }
        }
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (excluding spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: '" + mostCommonChar + "' with " + maxCount + " occurrences");
    }

    // Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        String[] words = text.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        System.out.println("===TEXT PROCESSING RESULTS===");

        // Clean and validate input
        String cleanedInput = cleanInput(input);
        System.out.println("Cleaned Input: " + cleanedInput);

        // Analyze text
        analyzeText(cleanedInput);

        // Get sorted words
        String[] sortedWords = getWordsSorted(cleanedInput);
        System.out.println("Sorted Words: " + Arrays.toString(sortedWords));

        scanner.close();
    }
}
