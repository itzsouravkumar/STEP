import java.util.Scanner;
public class findUniqueCharacters {

    public static int getLength(String text) {
        int length = 0;
        for (char c : text.toCharArray()) {
            length++;
        }
        return length;
    }
    public static char[] UniqueCharacters(String text) {
        int length = getLength(text);
        char[] uniqueChars = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueChars[index++] = currentChar;
            }
        }

        // Create a new array with the exact size of unique characters found
        char[] result = new char[index];
        System.arraycopy(uniqueChars, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find unique characters
        char[] uniqueChars = UniqueCharacters(input);

        // Display the result
        System.out.println("Unique characters:");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        scanner.close();
    }
}
