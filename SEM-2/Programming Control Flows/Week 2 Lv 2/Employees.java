import java.util.Scanner;

class Employees {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the salary: ");
		double salary = input.nextDouble();
		
		System.out.print("Enter the year of service: ");
		double years = input.nextDouble();
		
		if (years > 5) {
			double salaryWithBonus = salary * 5 / 100;
			System.out.println("The salary after bonus will be " + salaryWithBonus);
 		} else {
			System.out.println("This employee is not eligible for the bonus");
		}
		
		input.close();
	}
}