import java.util.Scanner;

class GradePercentage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the marks of Physics out of 100: ");
		double physics = input.nextDouble();
		System.out.print("Enter the marks of Chemistry out of 100: ");
		double chemistry = input.nextDouble();
		System.out.print("Enter the marks of Maths out of 100: ");
		double maths = input.nextDouble();
		
		double percentage = ((physics + chemistry + maths) / 300) * 100;

		char grade;
		String remarks;
		
		if (percentage < 40) {
			grade = 'R';
			remarks = "Remedial standards";
		} else if ((percentage > 39) && (percentage < 50)) {
			grade = 'E';
			remarks = "Level 1, too below agency-normalized standards";
		} else if ((percentage > 49) && (percentage < 60)) {
			grade = 'D';
			remarks = "Level 1, well below agency-normalized standards";
		} else if ((percentage > 59) && (percentage < 70)) {
			grade = 'C';
			remarks = "Level 2, below, but approaching agency-normalized standards";
		} else if ((percentage > 69) && (percentage < 80)) {
			grade = 'B';
			remarks = "Level 3, at agency-normalized standards";
		} else if (percentage > 79) {
			grade = 'A';
			remarks = "Level 4, above agency-normalized standards";
		} else {
			System.out.println("Invalid Input");
			return;
		}
		
		System.out.println("Average Marks: " + percentage + "\nGrade: " + grade + "\nRemarks: " + remarks);
		input.close();
	}
}