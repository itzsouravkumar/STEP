import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int n = input.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmiValues = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            weights[i] = input.nextDouble();

            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            heights[i] = input.nextDouble();

            bmiValues[i] = weights[i] / (heights[i] * heights[i]);

            if (bmiValues[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmiValues[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmiValues[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Height: " + heights[i] + " m");
            System.out.println("Weight: " + weights[i] + " kg");
            System.out.println("BMI: " + bmiValues[i]);
            System.out.println("Status: " + status[i]);
            System.out.println();
        }

        input.close();
    }
}
