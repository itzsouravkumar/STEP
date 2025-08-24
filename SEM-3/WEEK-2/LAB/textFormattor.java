import java.util.*;
public class textFormattor {

    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }

    public static List<String> justifyText(List<String> words, int width) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int lineLen = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && lineLen + 1 + words.get(j).length() <= width) {
                lineLen += 1 + words.get(j).length();
                j++;
            }

            StringBuilder line = new StringBuilder();
            int gaps = j - i - 1;
            if (j == words.size() || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words.get(k)).append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int space = totalSpaces / gaps;
                int extra = totalSpaces % gaps;
                for (int k = i; k < j - 1; k++) {
                    line.append(words.get(k));
                    for (int s = 0; s < space; s++) line.append(" ");
                    if (extra-- > 0) line.append(" ");
                }
                line.append(words.get(j - 1));
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }

    public static List<String> centerAlign(List<String> words, int width) {
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() + 1 > width) {
                int padding = (width - line.length()) / 2;
                result.add(" ".repeat(padding) + line.toString());
                line = new StringBuilder();
            }
            if (line.length() > 0) line.append(" ");
            line.append(word);
        }
        if (line.length() > 0) {
            int padding = (width - line.length()) / 2;
            result.add(" ".repeat(padding) + line.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        List<String> words = splitWords(text);
        List<String> justified = justifyText(words, width);
        List<String> centered = centerAlign(words, width);

        System.out.println("\nJustified:");
        int lineNo = 1;
        for (String line : justified) {
            System.out.printf("%2d | %s | (%d)%n", lineNo++, line, line.length());
        }

        System.out.println("\nCentered:");
        lineNo = 1;
        for (String line : centered) {
            System.out.printf("%2d | %s | (%d)%n", lineNo++, line, line.length());
        }
        sc.close();
    }
}

