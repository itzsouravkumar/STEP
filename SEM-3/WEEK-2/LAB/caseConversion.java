import java.util.*;
public class caseConversion {

    public static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }

    public static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public static String toUpperCaseASCII(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }

    public static String toLowerCaseASCII(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }

    public static String toTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(c));
                    newWord = false;
                } else {
                    sb.append(toLower(c));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.printf("%-15s %-30s %-30s%n", "Conversion", "Manual", "Built-in");
        System.out.printf("%-15s %-30s %-30s%n", "Uppercase", toUpperCaseASCII(text), text.toUpperCase());
        System.out.printf("%-15s %-30s %-30s%n", "Lowercase", toLowerCaseASCII(text), text.toLowerCase());
        System.out.printf("%-15s %-30s %-30s%n", "Titlecase", toTitleCase(text),
                Arrays.stream(text.split(" "))
                        .map(s -> s.isEmpty() ? s :
                                Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                        .reduce((a,b)->a+" "+b).orElse(""));

        sc.close();
    }
}
