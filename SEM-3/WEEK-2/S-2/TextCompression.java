import java.util.*;

public class TextCompression {

    static char[] uniqueChars(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (sb.indexOf(String.valueOf(c)) == -1) sb.append(c);
        }
        char[] arr = new char[sb.length()];
        for (int i = 0; i < sb.length(); i++) arr[i] = sb.charAt(i);
        return arr;
    }

    static int[] charFrequency(String text, char[] chars) {
        int[] freq = new int[chars.length];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]) freq[j]++;
            }
        }
        return freq;
    }

    static String[][] createCodes(char[] chars, int[] freq) {
        String[][] codes = new String[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            codes[i][0] = String.valueOf(chars[i]);
            codes[i][1] = Integer.toString(i);
        }
        return codes;
    }

    static String compress(String text, String[][] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < codes.length; j++) {
                if (c == codes[j][0].charAt(0)) sb.append(codes[j][1]);
            }
        }
        return sb.toString();
    }

    static String decompress(String compressed, String[][] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            String s = String.valueOf(compressed.charAt(i));
            for (int j = 0; j < codes.length; j++) {
                if (s.equals(codes[j][1])) sb.append(codes[j][0]);
            }
        }
        return sb.toString();
    }

    static void displayAnalysis(String text, char[] chars, int[] freq, String[][] codes, String compressed, String decompressed) {
        System.out.println("Character Frequency:");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " : " + freq[i]);
        }

        System.out.println("\nCompression Mapping:");
        for (int i = 0; i < codes.length; i++) {
            System.out.println(codes[i][0] + " -> " + codes[i][1]);
        }

        System.out.println("\nOriginal: " + text);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed: " + decompressed);

        double ratio = (double) compressed.length() / text.length();
        System.out.println("Compression Efficiency: " + (100 - ratio * 100) + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();

        char[] chars = uniqueChars(text);
        int[] freq = charFrequency(text, chars);
        String[][] codes = createCodes(chars, freq);
        String compressed = compress(text, codes);
        String decompressed = decompress(compressed, codes);

        displayAnalysis(text, chars, freq, codes, compressed, decompressed);

        sc.close();
    }
}

