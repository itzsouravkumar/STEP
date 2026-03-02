import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        double num;

        while (true) {
			System.out.print("Input value: ");
            num = input.nextDouble();
            if (num == 0) {
                break;
            }
            total += num;
        }
        System.out.println("Total sum: " + total);
		
		input.close();
    }
}