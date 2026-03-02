import java.util.Scanner;

class MultiplicationTable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] nums = new int[10];
		
		System.out.print("Enter the number: ");
		int num = input.nextInt();
		
		for (int i=0; i<nums.length; i++) {
			nums[i] =  num * (i + 1);
		}
		
		for (int i=0; i<nums.length; i++) {
			System.out.println(num + " * " + (i+1) + " = " + nums[i]);
		}
		
		input.close();
	}
}