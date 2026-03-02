import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int fee; 
        double discountPercent;

        System.out.print("Enter the fee: ");
        fee = input.nextInt();

        System.out.print("Enter the discount percent: ");
        discountPercent = input.nextDouble();

        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee + ".");

        input.close();
    }
}
