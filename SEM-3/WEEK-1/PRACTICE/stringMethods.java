import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class stringMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter your favourite programming language: ");
        String favLang = sc.nextLine();

        System.out.print("Enter your programming language experience: ");
        String experience = "";
        try {
            experience = br.readLine().trim();
        } catch (IOException e) {
            System.out.println("Error reading experience: " + e.getMessage());
        }

        // Display full name
        System.out.println("Full Name: " + firstName + " " + lastName);

        // Count characters without spaces in experience
        int totalChars = experience.replace(" ", "").length();
        System.out.println("Total Characters in Experience (no spaces): " + totalChars);

        // Display favourite language in uppercase
        System.out.println("Favourite Language: " + favLang.toUpperCase());

        sc.close();
    }
}
