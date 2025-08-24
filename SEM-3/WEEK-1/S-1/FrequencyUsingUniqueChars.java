import java.util.Scanner;

public class FrequencyUsingUniqueChars {

    // Method to find unique characters
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()]; // To store unique chars
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            // if not -> add to unique list
            if (!isDuplicate) {
                temp[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // same size of uniqueChars
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }


    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256]; 

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequency[c]++;
        }

        char[] uniqueChars = uniqueCharacters(text);

        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]); // character
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]); // frequency
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get frequency
        String[][] frequencyData = findFrequency(input);

        // Display result
        System.out.println("Character Frequency:");
        for (String[] entry : frequencyData) {
            System.out.println("'" + entry[0] + "' : " + entry[1]);
        }

        scanner.close();
    }
}
