import java.util.*;
public class caserCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c))
                sb.append((char)('A' + (c - 'A' + shift + 26) % 26));
            else if (Character.isLowerCase(c))
                sb.append((char)('a' + (c - 'a' + shift + 26) % 26));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void printAsciiValues(String text) {
        for (char c : text.toCharArray())
            System.out.print(c + "(" + (int)c + ") ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        System.out.print("Original: "); printAsciiValues(text);
        String encrypted = encrypt(text, shift);
        System.out.print("Encrypted: "); printAsciiValues(encrypted);
        String decrypted = decrypt(encrypted, shift);
        System.out.print("Decrypted: "); printAsciiValues(decrypted);

        System.out.println("Decryption valid? " + text.equals(decrypted));
        sc.close();
    }
}

