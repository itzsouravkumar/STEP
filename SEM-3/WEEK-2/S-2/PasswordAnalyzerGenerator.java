import java.util.*;

public class PasswordAnalyzerGenerator {

    static int analyzePassword(String password) {
        int upper = 0, lower = 0, digit = 0, special = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int ascii = (int) c;

            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digit++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }

        int score = 0;
        if (password.length() > 8) score += (password.length() - 8) * 2;
        if (upper > 0) score += 10;
        if (lower > 0) score += 10;
        if (digit > 0) score += 10;
        if (special > 0) score += 10;

        if (password.contains("123") || password.contains("abc") || password.toLowerCase().contains("qwerty")) {
            score -= 10;
        }

        return Math.max(score, 0);
    }

    static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()_+";

        String all = upper + lower + digits + special;
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(upper.charAt(rand.nextInt(upper.length())));
        sb.append(lower.charAt(rand.nextInt(lower.length())));
        sb.append(digits.charAt(rand.nextInt(digits.length())));
        sb.append(special.charAt(rand.nextInt(special.length())));

        for (int i = sb.length(); i < length; i++) {
            sb.append(all.charAt(rand.nextInt(all.length())));
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) chars.add(sb.charAt(i));
        Collections.shuffle(chars);

        StringBuilder finalPass = new StringBuilder();
        for (char c : chars) finalPass.append(c);

        return finalPass.toString();
    }

    static void displayAnalysis(List<String> passwords) {
        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-12s %-8s %-10s\n",
                "Password", "Length", "Upper", "Lower", "Digits", "Special", "Score", "Strength");

        for (String pass : passwords) {
            int upper = 0, lower = 0, digit = 0, special = 0;
            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                int ascii = (int) c;
                if (ascii >= 65 && ascii <= 90) upper++;
                else if (ascii >= 97 && ascii <= 122) lower++;
                else if (ascii >= 48 && ascii <= 57) digit++;
                else if (ascii >= 33 && ascii <= 126) special++;
            }
            int score = analyzePassword(pass);
            System.out.printf("%-15s %-8d %-8d %-8d %-8d %-12d %-8d %-10s\n",
                    pass, pass.length(), upper, lower, digit, special, score, strengthLevel(score));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> passwords = new ArrayList<>();

        System.out.print("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords.add(sc.nextLine());
        }

        displayAnalysis(passwords);

        System.out.print("\nEnter desired length for new strong password:");
        int len = sc.nextInt();
        System.out.println("Generated Password: " + generatePassword(len));

        sc.close();
    }
}
