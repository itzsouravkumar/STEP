import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class replaceOccurences {

    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(pattern);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(pattern, index + 1);
        }
        return positions;
    }

    // Manual replace
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // Compare with built-in
    public static boolean compareWithBuiltIn(String text, String find, String replace, String manualResult) {
        return manualResult.equals(text.replace(find, replace));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter main text: ");
        String text = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter substring to replace: ");
        String replace = sc.nextLine();

        String manualResult = manualReplace(text, find, replace);
        String builtInResult = text.replace(find, replace);

        System.out.println("\nManual Replace: " + manualResult);
        System.out.println("Built-in Replace: " + builtInResult);
        System.out.println("Match? " + compareWithBuiltIn(text, find, replace, manualResult));
        sc.close();
    }
}
