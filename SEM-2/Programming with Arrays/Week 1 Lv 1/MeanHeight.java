import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] heights = new double[11];

        double sum = 0;

        System.out.print("Enter the heights of 11 players: ");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        double mean = sum / heights.length;

        System.out.printf("Mean height of the football team: %.2f%n", mean);

        input.close();
    }
}
