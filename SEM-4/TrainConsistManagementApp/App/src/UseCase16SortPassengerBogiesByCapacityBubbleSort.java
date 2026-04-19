import java.util.Arrays;

public class UseCase16SortPassengerBogiesByCapacityBubbleSort {
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("UC16 - Sort Passenger Bogies by Capacity (Bubble Sort)");

        int[] capacities = {72, 56, 24, 70, 60};
        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        bubbleSort(capacities);

        System.out.println("Sorted Capacities:   " + Arrays.toString(capacities));
        System.out.println("UC16 bubble sort completed...");
    }
}
