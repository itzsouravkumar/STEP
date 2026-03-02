import java.util.Scanner;

class FizzBuzzWhile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");

		int tillNum = input.nextInt();
		
		if (tillNum >= 1) {
			int i = 1;
			while (i<=tillNum) {
				if ((i % 3 == 0) && (i % 5 == 0)) {
					System.out.println("FizzBuzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
				
				i++;
			}
		} else {
			System.out.println("Please enter a positive number.");
		}
		
		input.close();
	}
}