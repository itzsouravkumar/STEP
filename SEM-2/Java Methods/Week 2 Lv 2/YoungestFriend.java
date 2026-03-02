import java.util.Scanner;

public class YoungestFriend {
	public static String findYoungest(int[] ages) {
        int minAgeIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }
        return (minAgeIndex == 0) ? "Amar" : (minAgeIndex == 1) ? "Akbar" : "Anthony";
    }

    public static String findTallest(double[] heights) {
        int maxHeightIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        return (maxHeightIndex == 0) ? "Amar" : (maxHeightIndex == 1) ? "Akbar" : "Anthony";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter the age and height of Amar:");
        ages[0] = scanner.nextInt();
        heights[0] = scanner.nextDouble();

        System.out.println("Enter the age and height of Akbar:");
        ages[1] = scanner.nextInt();
        heights[1] = scanner.nextDouble();

        System.out.println("Enter the age and height of Anthony:");
        ages[2] = scanner.nextInt();
        heights[2] = scanner.nextDouble();

        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
		
		scanner.close();
    }
}