import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double heightCm;

        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble();

        double cmPerInch = 2.54;
        int inchesPerFoot = 12;

        double totalInches = heightCm / cmPerInch;

        int feet = (int) (totalInches / inchesPerFoot);
        double inches = totalInches % inchesPerFoot;

        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches + ".");

        input.close();
    }
}
