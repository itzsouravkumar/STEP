import java.util.Scanner;
public class vowels_2 {
    public static String checkCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if vowel or consonant
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] findVowelsAndConsonants(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkCharacter(str.charAt(i));
        }
        return result;
    }

    public static void displayResult(String[][] data) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] result = findVowelsAndConsonants(input);
        displayResult(result);

        scanner.close();
    }
}
