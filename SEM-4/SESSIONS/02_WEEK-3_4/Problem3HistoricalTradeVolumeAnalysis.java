import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3HistoricalTradeVolumeAnalysis {

    static class Trade {
        String tradeId;
        int volume;

        Trade(String tradeId, int volume) {
            this.tradeId = tradeId;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return tradeId + ":" + volume;
        }
    }

    static void mergeSortByVolumeAsc(Trade[] arr) {
        if (arr.length <= 1) {
            return;
        }
        Trade[] temp = new Trade[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    static void mergeSort(Trade[] arr, Trade[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    static void merge(Trade[] arr, Trade[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i].volume <= arr[j].volume) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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

    static void quickSortByVolumeDesc(Trade[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionDesc(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partitionDesc(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume >= pivot) {
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static List<Trade> mergeTwoSortedTradeLists(List<Trade> first, List<Trade> second) {
        ArrayList<Trade> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < first.size() && j < second.size()) {
            if (first.get(i).volume <= second.get(j).volume) {
                merged.add(first.get(i++));
            } else {
                merged.add(second.get(j++));
            }
        }

        while (i < first.size()) {
            merged.add(first.get(i++));
        }

        while (j < second.size()) {
            merged.add(second.get(j++));
        }

        return merged;
    }

    static long totalVolume(Trade[] trades) {
        long total = 0;
        for (Trade t : trades) {
            total += t.volume;
        }
        return total;
    }

    static long totalVolume(List<Trade> trades) {
        long total = 0;
        for (Trade t : trades) {
            total += t.volume;
        }
        return total;
    }

    public static void main(String[] args) {
        Trade[] input = {
            new Trade("trade3", 500),
            new Trade("trade1", 100),
            new Trade("trade2", 300)
        };

        Trade[] mergeSorted = Arrays.copyOf(input, input.length);
        mergeSortByVolumeAsc(mergeSorted);
        System.out.println("MergeSort (asc): " + Arrays.toString(mergeSorted));

        Trade[] quickSorted = Arrays.copyOf(input, input.length);
        quickSortByVolumeDesc(quickSorted);
        System.out.println("QuickSort (desc): " + Arrays.toString(quickSorted));

        List<Trade> morning = Arrays.asList(new Trade("m1", 100), new Trade("m2", 300));
        List<Trade> afternoon = Arrays.asList(new Trade("a1", 500));
        List<Trade> merged = mergeTwoSortedTradeLists(morning, afternoon);
        System.out.println("Merged sessions: " + merged);
        System.out.println("Merged total volume: " + totalVolume(merged));
    }
}
