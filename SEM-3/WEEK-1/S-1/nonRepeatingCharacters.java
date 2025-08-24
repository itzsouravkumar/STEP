import java.util.Scanner;
public class nonRepeatingCharacters {
    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequency = new int[256]; // Array to store frequency of characters

        // Loop through the text to find the frequency of characters
        for (char c : text.toCharArray()) {
            frequency[c]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (frequency[currentChar] == 1) {
                return currentChar;
            }
        }

        return '\0';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find the first non-repeating character
        char result = findFirstNonRepeatingCharacter(input);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        scanner.close();
    }
}
