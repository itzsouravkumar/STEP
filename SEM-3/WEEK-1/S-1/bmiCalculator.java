import java.util.Scanner;

public class bmiCalculator {
    // Method to determine BMI status based on BMI value
    public static String getStatus(float bmi) {
        if (bmi < 18.4) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 39.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
    // Method to calculate BMI & display output and status in Table
    public static void displayBMI(String[][] personData) {
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Person", "Weight(kg)", "Height(cm)", "BMI");
        for (int i = 0; i < personData.length; i++) {
            float weight = Float.parseFloat(personData[i][0]);
            float height = Float.parseFloat(personData[i][1]) / 100; // Convert cm to m
            float bmi = weight / (height * height);
            String status = getStatus(bmi);
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f (%s)\n", (i + 1), weight, height, bmi, status);
        }
    }

    public static void main(String[] args) {
        int totalPerson = 10;
        float weight, height;
        // 2D Array to store person's weight and height in string format
        String[][] personData = new String[totalPerson][2];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < totalPerson; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weight = scanner.nextFloat();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            height = scanner.nextFloat();
            personData[i][0] = String.valueOf(weight);
            personData[i][1] = String.valueOf(height);
        }
        // Calculate and display BMI for each person
        displayBMI(personData);
        scanner.close();
    }
}
