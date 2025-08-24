import java.util.Scanner;
public class splitText_3 {
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
        words[wordIndex] = str.substring(startIndex);

        return words;
    }

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

    public static String[][] getWordLengths(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return wordLengths;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (String[] wordLength : wordLengths) {
            int length = Integer.parseInt(wordLength[1]);
            if (length < minLength) {
                minLength = length;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return new int[]{minLength, maxLength};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] words = splitTextIntoWords(input);
        String[][] wordLengths = getWordLengths(words);
        int[] minMaxLengths = findShortestAndLongest(wordLengths);

        System.out.println("Shortest word length: " + minMaxLengths[0]);
        System.out.println("Longest word length: " + minMaxLengths[1]);

        scanner.close();
    }
}
