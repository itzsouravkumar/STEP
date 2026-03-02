import java.util.Scanner;

public class ContactDetails {

    public static void main(String[] args) {
        // Creating variables to store user contact details

        String name, email, phone;
        int age;
        double height;
		
        // Creating Scanner object to take input from user
        Scanner input = new Scanner(System.in);

        // Taking user contact details as input
        System.out.print("Enter your name: ");
        name = input.nextLine();
        System.out.print("Enter your email: ");
        email = input.nextLine();
        System.out.print("Enter your phone number: ");
        phone = input.nextLine();
        System.out.print("Enter your age: ");
        age = input.nextInt();
        System.out.print("Enter your height: ");
        height = input.nextDouble();

        // Displaying user contact details in a single line
        System.out.println("User Contact Details:");
        System.out.println("Name: " + name + ", Email: " + email + 
                           ", Phone: " + phone +
                           ",\nAge: " + age + ", Height: " + height);       

        input.close(); // Closing the Scanner object

    }

}