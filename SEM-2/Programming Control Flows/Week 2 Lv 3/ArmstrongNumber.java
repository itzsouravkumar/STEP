import java.util.Scanner;

class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		
		int sum = 0;
		int originalNum = num;
		
		while (originalNum != 0) {
			int rem = originalNum % 10;
			sum += rem * rem * rem;
			originalNum = originalNum / 10;
		}
		
		if (num == sum) {
			System.out.println(num + " is an Armstrong number.");
		} else {
			System.out.println(num + " is not an Armstrong number.");
		}
		
		input.close();
	}
}