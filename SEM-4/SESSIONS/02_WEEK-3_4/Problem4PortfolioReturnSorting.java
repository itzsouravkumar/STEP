import java.util.Arrays;
import java.util.Random;

public class Problem4PortfolioReturnSorting {

    enum PivotStrategy {
        RANDOM,
        MEDIAN_OF_THREE
    }

    static class Asset {
        String symbol;
        double returnRate;
        double volatility;
        int originalOrder;

        Asset(String symbol, double returnRate, double volatility, int originalOrder) {
            this.symbol = symbol;
            this.returnRate = returnRate;
            this.volatility = volatility;
            this.originalOrder = originalOrder;
        }

        @Override
        public String toString() {
            return symbol + ":" + returnRate + "% (vol=" + volatility + ")";
        }
    }

    static void mergeSortReturnAscStable(Asset[] assets) {
        if (assets.length <= 1) {
            return;
        }
        Asset[] temp = new Asset[assets.length];
        mergeSort(assets, temp, 0, assets.length - 1);
    }

    static void mergeSort(Asset[] arr, Asset[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    static void merge(Asset[] arr, Asset[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i].returnRate < arr[j].returnRate) {
                temp[k++] = arr[i++];
            } else if (arr[i].returnRate > arr[j].returnRate) {
                temp[k++] = arr[j++];
            } else {
                if (arr[i].originalOrder <= arr[j].originalOrder) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
        }
    }

    static void quickSortReturnDescVolAsc(Asset[] assets, PivotStrategy strategy) {
        quickSortHybrid(assets, 0, assets.length - 1, strategy, new Random());
    }

    static void quickSortHybrid(Asset[] arr, int low, int high, PivotStrategy strategy, Random random) {
        while (low < high) {
            if (high - low < 12) {
                insertionSortRange(arr, low, high);
                return;
            }

            int pivotIndex = choosePivot(arr, low, high, strategy, random);
            swap(arr, pivotIndex, high);
            int p = partition(arr, low, high);

            if (p - low < high - p) {
                quickSortHybrid(arr, low, p - 1, strategy, random);
                low = p + 1;
            } else {
                quickSortHybrid(arr, p + 1, high, strategy, random);
                high = p - 1;
            }
        }
    }

    static int choosePivot(Asset[] arr, int low, int high, PivotStrategy strategy, Random random) {
        if (strategy == PivotStrategy.RANDOM) {
            return low + random.nextInt(high - low + 1);
        }
        int mid = low + (high - low) / 2;
        return medianOfThree(arr, low, mid, high);
    }

    static int medianOfThree(Asset[] arr, int a, int b, int c) {
        if (compareDescVolAsc(arr[a], arr[b]) > 0) {
            int t = a;
            a = b;
            b = t;
        }
        if (compareDescVolAsc(arr[b], arr[c]) > 0) {
            int t = b;
            b = c;
            c = t;
        }
        if (compareDescVolAsc(arr[a], arr[b]) > 0) {
            int t = a;
            a = b;
            b = t;
        }
        return b;
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareDescVolAsc(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static int compareDescVolAsc(Asset a, Asset b) {
        if (a.returnRate != b.returnRate) {
            return Double.compare(b.returnRate, a.returnRate);
        }
        return Double.compare(a.volatility, b.volatility);
    }

    static void insertionSortRange(Asset[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = arr[i];
            int j = i - 1;

            while (j >= low && compareDescVolAsc(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Asset[] input = {
            new Asset("AAPL", 12.0, 4.2, 0),
            new Asset("TSLA", 8.0, 6.5, 1),
            new Asset("GOOG", 15.0, 3.8, 2)
        };

        Asset[] mergeSorted = Arrays.copyOf(input, input.length);
        mergeSortReturnAscStable(mergeSorted);
        System.out.println("Merge (return asc, stable): " + Arrays.toString(mergeSorted));

        Asset[] quickSorted = Arrays.copyOf(input, input.length);
        quickSortReturnDescVolAsc(quickSorted, PivotStrategy.MEDIAN_OF_THREE);
        System.out.println("Quick (return desc + vol asc): " + Arrays.toString(quickSorted));
    }
}
