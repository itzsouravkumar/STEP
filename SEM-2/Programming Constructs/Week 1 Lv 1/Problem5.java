public class Problem5 {
	public static void main(String[] args) {
		int noOfPens = 14, noOfStudents = 3;
		
		int eachStudentGets = noOfPens/noOfStudents;
		int remainingPens = noOfPens%noOfStudents;
		
		System.out.println("The Pen Per Student is " + eachStudentGets + " and the remaining pen not distributed is " + remainingPens + ".");
	}
}