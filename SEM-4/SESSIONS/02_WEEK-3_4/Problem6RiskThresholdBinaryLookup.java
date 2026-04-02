import java.util.Arrays;

public class Problem6RiskThresholdBinaryLookup {

    static class SearchResult {
        int index;
        int comparisons;

        SearchResult(int index, int comparisons) {
            this.index = index;
            this.comparisons = comparisons;
        }
    }

    static SearchResult linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                return new SearchResult(i, comparisons);
            }
        }
        return new SearchResult(-1, comparisons);
    }

    static int insertionPoint(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    static Integer floorValue(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        Integer floor = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] <= target) {
                floor = sortedArr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    static Integer ceilingValue(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        Integer ceiling = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] >= target) {
                ceiling = sortedArr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceiling;
    }

    static int binaryComparisonsForTarget(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;
            if (sortedArr[mid] == target) {
                return comparisons;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {
        int[] unsortedRisks = {50, 10, 100, 25};
        int target = 30;

        SearchResult linear = linearSearch(unsortedRisks, target);
        System.out.println("Linear search in unsorted risks " + Arrays.toString(unsortedRisks)
            + ": index=" + linear.index + " (" + linear.comparisons + " comparisons)");

        int[] sortedRisks = Arrays.copyOf(unsortedRisks, unsortedRisks.length);
        Arrays.sort(sortedRisks);
        int insertion = insertionPoint(sortedRisks, target);
        Integer floor = floorValue(sortedRisks, target);
        Integer ceiling = ceilingValue(sortedRisks, target);
        int binaryComparisons = binaryComparisonsForTarget(sortedRisks, target);

        System.out.println("Sorted risks: " + Arrays.toString(sortedRisks));
        System.out.println("Binary insertion point for " + target + ": " + insertion);
        System.out.println("Floor(" + target + "): " + floor + ", Ceiling(" + target + "): " + ceiling
            + " (" + binaryComparisons + " comparisons)");
    }
}
