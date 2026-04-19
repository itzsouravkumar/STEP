import java.util.Arrays;

public class UseCase19BinarySearchForBogieIdOptimizedSearching {
    public static boolean binarySearch(String[] bogieIds, String searchKey) {
        String[] sortedBogieIds = Arrays.copyOf(bogieIds, bogieIds.length);
        Arrays.sort(sortedBogieIds);

        int low = 0;
        int high = sortedBogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedBogieIds[mid].compareTo(searchKey);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC19 - Binary Search for Bogie ID (Optimized Searching)");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Input Bogie IDs: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        boolean found = binarySearch(bogieIds, searchKey);
        if (found) {
            System.out.println("Result: Bogie ID found.");
        } else {
            System.out.println("Result: Bogie ID not found.");
        }

        System.out.println("UC19 binary search completed...");
    }
}
