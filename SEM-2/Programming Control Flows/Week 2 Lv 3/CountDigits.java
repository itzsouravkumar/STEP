import java.util.Scanner;

class CountDigits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		
		int originalNum = num;
		int count = 0;
		
		while (originalNum != 0) {
			originalNum = originalNum / 10;
			count++;
		}
		
		System.out.println(num + " has " + count + " digits.");
		
		input.close();
	}
}