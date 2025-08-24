public class stringBuiltInMethods {
     public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Display original string length including spaces
        System.out.println("Original Length (with spaces): " + sampleText.length());

        // 2. Remove leading and trailing spaces, show new length
        String trimmed = sampleText.trim();
        System.out.println("Trimmed String: \"" + trimmed + "\"");
        System.out.println("Length after trim: " + trimmed.length());

        // 3. Find and display the character at index 5
        System.out.println("Character at index 5: " + sampleText.charAt(5));

        // 4. Extract substring "Programming"
        String substring = trimmed.substring(trimmed.indexOf("Programming"), trimmed.indexOf("Programming") + "Programming".length());
        System.out.println("Extracted substring: " + substring);

        // 5. Find the index of the word "Fun"
        System.out.println("Index of 'Fun': " + trimmed.indexOf("Fun"));

        // 6. Check if the string contains "Java" (case-sensitive)
        System.out.println("Contains 'Java': " + trimmed.contains("Java"));

        // 7. Check if the string starts with "Java" (after trimming)
        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));

        // 8. Check if the string ends with an exclamation mark
        System.out.println("Ends with '!': " + trimmed.endsWith("!"));

        // 9. Convert the entire string to uppercase
        System.out.println("Uppercase: " + trimmed.toUpperCase());

        // 10. Convert the entire string to lowercase
        System.out.println("Lowercase: " + trimmed.toLowerCase());

        // Count vowels
        System.out.println("Vowel Count: " + countVowels(trimmed));

        // Find all occurrences of 'a'
        findAllOccurrences(trimmed, 'a');
    }

    // Method to count vowels
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        System.out.print("Occurrences of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}