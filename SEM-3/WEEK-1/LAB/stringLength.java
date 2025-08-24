import java.util.Scanner;

public class stringLength {
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int length = getStringLength(input);
        System.out.println("Length of the string (without using length()): " + length);
        System.out.println("Length of the string (using length()): " + input.length());
        scanner.close();
    }

}
