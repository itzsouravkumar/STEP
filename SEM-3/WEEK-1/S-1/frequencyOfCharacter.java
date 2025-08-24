import java.util.Scanner;

public class frequencyOfCharacter {

    // Method to find frequency of characters
    public static int[][] findFrequency(String text) {
        int[] frequency = new int[256]; // Frequency table for ASCII characters

        // Count frequencies
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);  // Using charAt as per requirement
            frequency[c]++;
        }

        // Count how many unique characters exist
        int uniqueCount = 0;
        for (int freq : frequency) {
            if (freq > 0) {
                uniqueCount++;
            }
        }

        // Create 2D array to store character and frequency
        int[][] result = new int[uniqueCount][2];
        int index = 0;

     
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                result[index][0] = i;         // ASCII value
                result[index][1] = frequency[i]; // Store frequency
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find frequency
        int[][] frequencyData = findFrequency(input);

        // Display result
        System.out.println("Character Frequency:");
        for (int[] entry : frequencyData) {
            System.out.printf("'%c' : %d\n", entry[0], entry[1]);
        }

        scanner.close();
    }
}
