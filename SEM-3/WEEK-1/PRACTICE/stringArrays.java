import java.util.Scanner;
public class stringArrays {
    // Method that takes a string array of names and returns the longest name
    public static String findLongestName(String[] names) {
        String longestName = "";
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        return longestName;
    }
    // Method that counts how many names start with given letter(case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        for (String name : names) {
            if (name.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                count++;
            }
        }
        return count;
    }
    // Method to format all names as first and last name (assuming names are in "First Last" format)
    public static void formatNames(String[] names) {
        for (String name : names) {
            String[] parts = name.split(" ");
            if (parts.length == 2) {
                String firstName = parts[0];
                String lastName = parts[1];
                System.out.println("Formatted Name: " + lastName + ", " + firstName);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter names separated by commas: ");
        String input = sc.nextLine();
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }

        // Find and display the longest name
        String longestName = findLongestName(names);
        System.out.println("Longest Name: " + longestName);

        // Count and display names starting with a specific letter
        System.out.print("Enter a letter to count names starting with it: ");
        char letter = sc.nextLine().charAt(0);
        int count = countNamesStartingWith(names, letter);
        System.out.println("Number of names starting with '" + letter + "': " + count);

        // Format and display names
        System.out.println("Formatted Names:");
        formatNames(names);

        sc.close();
    }
}
