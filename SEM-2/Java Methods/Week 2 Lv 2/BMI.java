import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] data = new double[10][3];
        String[] bmiStatuses = new String[10];

        System.out.println("Enter the weight (kg) and height (cm) for 10 members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " - Weight (kg): ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Member " + (i + 1) + " - Height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100;
            data[i][2] = weight / (heightInMeters * heightInMeters);

            double bmi = data[i][2];
            if (bmi < 18.5) {
                bmiStatuses[i] = "Underweight";
            } else if (bmi < 25) {
                bmiStatuses[i] = "Normal";
            } else if (bmi < 40) {
                bmiStatuses[i] = "Overweight";
            } else {
                bmiStatuses[i] = "Obese";
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Member " + (i + 1) + ":");
            System.out.println("Weight: " + data[i][0] + " kg");
            System.out.println("Height: " + data[i][1] + " cm");
            System.out.println("BMI: " + data[i][2]);
            System.out.println("Status: " + bmiStatuses[i]);
            System.out.println();
        }
    }
}