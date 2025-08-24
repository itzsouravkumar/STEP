import java.util.Scanner;
public class vowels {
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

    public static int[] countVowelsAndConsonants(String str) {
        int[] counts = new int[2]; // 0: vowels, 1: consonants
        for (int i = 0; i < str.length(); i++) {
            String result = checkCharacter(str.charAt(i));
            if (result.equals("Vowel")) {
                counts[0]++;
            } else if (result.equals("Consonant")) {
                counts[1]++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(input);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);

        scanner.close();
    }
}
