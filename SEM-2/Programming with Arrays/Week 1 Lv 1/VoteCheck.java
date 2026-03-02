import java.util.Scanner;

class VoteCheck {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] ages = new int[10];
		
		System.out.print("Enter the Ages: ");
		
		for (int i=0; i<ages.length; i++) {
			int age = input.nextInt();
			ages[i] = age;
		}
		
		for (int i=0; i<ages.length; i++) {
			if (ages[i] < 0) {
				System.err.println("Invalid age");
			} else if (ages[i] < 18) {
				System.out.println("The student with the age " + ages[i] + " cannot vote");
			} else {
				System.out.println("The student with the age " + ages[i] + " can vote");
			}
		}
		
		input.close();
	}
}