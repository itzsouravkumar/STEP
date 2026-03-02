import java.util.Scanner;

class OddEven {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");

		int tillNum = input.nextInt();
		
		if (tillNum >= 1) {
			for (int i=1; i<=tillNum; i++) {
				if (i % 2 == 0) {
					System.out.println(i + " is Even.");
				} else {
					System.out.println(i + " is Odd.");
				}
			}
		} else {
			System.out.println("Please enter a natural number.");
		}
		
		input.close();
	}
}