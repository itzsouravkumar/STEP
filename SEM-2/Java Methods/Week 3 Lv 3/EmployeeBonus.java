import java.util.Random;

public class EmployeeBonus {
    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData();
        double[][] updatedData = calculateBonus(employeeData);
        displaySummary(employeeData, updatedData);
    }

    public static int[][] generateEmployeeData() {
        int[][] data = new int[10][2];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            data[i][0] = random.nextInt(90000) + 10000;
            data[i][1] = random.nextInt(10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonus(int[][] employeeData) {
        double[][] updatedData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonusAmount = salary * bonusPercentage;
            double newSalary = salary + bonusAmount;

            updatedData[i][0] = newSalary;
            updatedData[i][1] = bonusAmount;
        }
        return updatedData;
    }

    public static void displaySummary(int[][] employeeData, double[][] updatedData) {
        double sumOldSalary = 0, sumNewSalary = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            sumOldSalary += employeeData[i][0];
            sumNewSalary += updatedData[i][0];
            totalBonus += updatedData[i][1];

            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("Old Salary: " + employeeData[i][0]);
            System.out.println("Years of Service: " + employeeData[i][1]);
            System.out.println("New Salary: " + updatedData[i][0]);
            System.out.println("Bonus Amount: " + updatedData[i][1]);
            System.out.println();
        }

        System.out.println("Total Old Salary: " + sumOldSalary);
        System.out.println("Total New Salary: " + sumNewSalary);
        System.out.println("Total Bonus Amount: " + totalBonus);
    }
}