import java.util.Scanner;

public class FrequencyUsingNestedLoops {

    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray(); 
        int[] freq = new int[chars.length]; 

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; 

            if (chars[i] == '0') {
                continue;
            }

            // Inner loop to find duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate as counted
                }
            }
        }

        // Count unique characters for final array size
        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        // Create a String array to store results
        String[] result = new String[uniqueCount];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = "'" + chars[i] + "' : " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get frequency
        String[] frequencyData = findFrequency(input);

        // Display result
        System.out.println("Character Frequency:");
        for (String entry : frequencyData) {
            System.out.println(entry);
        }

        scanner.close();
    }
}
