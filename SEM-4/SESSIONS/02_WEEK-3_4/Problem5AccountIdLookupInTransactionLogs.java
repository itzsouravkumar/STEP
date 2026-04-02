import java.util.Arrays;

public class Problem5AccountIdLookupInTransactionLogs {

    static class LinearSearchResult {
        int firstIndex;
        int lastIndex;
        int comparisons;

        LinearSearchResult(int firstIndex, int lastIndex, int comparisons) {
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;
            this.comparisons = comparisons;
        }
    }

    static class BinarySearchResult {
        int index;
        int count;
        int comparisons;

        BinarySearchResult(int index, int count, int comparisons) {
            this.index = index;
            this.count = count;
            this.comparisons = comparisons;
        }
    }

    static LinearSearchResult linearFirstLast(String[] logs, String target) {
        int first = -1;
        int last = -1;
        int comparisons = 0;

        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return new LinearSearchResult(first, last, comparisons);
    }

    static BinarySearchResult binarySearchWithCount(String[] sortedLogs, String target) {
        int comparisons = 0;
        int low = 0;
        int high = sortedLogs.length - 1;
        int found = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;
            int cmp = sortedLogs[mid].compareTo(target);

            if (cmp == 0) {
                found = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found == -1) {
            return new BinarySearchResult(-1, 0, comparisons);
        }

        int first = lowerBound(sortedLogs, target);
        int lastExclusive = upperBound(sortedLogs, target);
        int count = lastExclusive - first;

        return new BinarySearchResult(found, count, comparisons);
    }

    static int lowerBound(String[] arr, String target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    static int upperBound(String[] arr, String target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        LinearSearchResult linear = linearFirstLast(logs, "accB");
        System.out.println("Linear first accB: " + linear.firstIndex + ", last accB: " + linear.lastIndex
            + " (" + linear.comparisons + " comparisons)");

        String[] sortedLogs = Arrays.copyOf(logs, logs.length);
        Arrays.sort(sortedLogs);
        System.out.println("Sorted logs: " + Arrays.toString(sortedLogs));

        BinarySearchResult binary = binarySearchWithCount(sortedLogs, "accB");
        System.out.println("Binary accB: index " + binary.index + " (" + binary.comparisons
            + " comparisons), count=" + binary.count);
    }
}
