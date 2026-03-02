import java.util.Scanner;

class CheckNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] nums = new int[5];
		
		System.out.print("Enter the 5 numbers: ");
		
		for (int i=0; i<nums.length; i++) {
			int num = input.nextInt();
			nums[i] = num;
		}
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i] < 0) {
				System.out.println("negative");
			} else if (nums[i] == 0) {
				System.out.println("0");
			} else if (nums[i] % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		}
		
		if (nums[0] < nums[nums.length-1]) {
			System.out.println("First element is smaller than the last element");
		} else {
			System.out.println("First element is greater than the last element");
		}
		
		input.close();
	}
}