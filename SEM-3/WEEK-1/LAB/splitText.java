import java.util.Scanner;
public class splitText {
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception caught when index exceeds string length
        }
        return count;
    }

    public static String[] splitTextIntoWords(String str) {
        int wordCount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int startIndex = 0;
        int wordIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                words[wordIndex++] = str.substring(startIndex, i);
                startIndex = i + 1;
            }
        }
        words[wordIndex] = str.substring(startIndex); // Last word

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int length = getStringLength(input);
        System.out.println("Length of the string (without using length()): " + length);
        
        String[] userDefinedSplit = splitTextIntoWords(input);
        String[] builtInSplit = input.split(" ");

        boolean areEqual = compareArrays(userDefinedSplit, builtInSplit);
        
        System.out.println("User-defined split: ");
        for (String word : userDefinedSplit) {
            System.out.print(word + " ");
        }
        
        System.out.println("\nBuilt-in split: ");
        for (String word : builtInSplit) {
            System.out.print(word + " ");
        }

        System.out.println("\nAre both splits equal? " + areEqual);
        
        scanner.close();
    }
}