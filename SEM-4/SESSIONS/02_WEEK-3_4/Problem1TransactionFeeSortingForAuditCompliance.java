import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Problem1TransactionFeeSortingForAuditCompliance {

    static class Transaction {
        String id;
        double fee;
        LocalTime timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = LocalTime.parse(timestamp);
        }

        @Override
        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    static class BubbleResult {
        int passes;
        int swaps;

        BubbleResult(int passes, int swaps) {
            this.passes = passes;
            this.swaps = swaps;
        }
    }

    static BubbleResult bubbleSortByFee(ArrayList<Transaction> transactions) {
        int n = transactions.size();
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    Transaction temp = transactions.get(j);
                    transactions.set(j, transactions.get(j + 1));
                    transactions.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return new BubbleResult(passes, swaps);
    }

    static void insertionSortByFeeThenTimestamp(ArrayList<Transaction> transactions) {
        for (int i = 1; i < transactions.size(); i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;

            while (j >= 0 && compareByFeeThenTimestamp(transactions.get(j), key) > 0) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }

            transactions.set(j + 1, key);
        }
    }

    static int compareByFeeThenTimestamp(Transaction a, Transaction b) {
        if (a.fee < b.fee) {
            return -1;
        }
        if (a.fee > b.fee) {
            return 1;
        }
        return a.timestamp.compareTo(b.timestamp);
    }

    static List<Transaction> highFeeOutliers(List<Transaction> transactions) {
        ArrayList<Transaction> outliers = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.fee > 50.0) {
                outliers.add(t);
            }
        }
        return outliers;
    }

    static void printList(String label, List<Transaction> list) {
        System.out.println(label + list);
    }

    public static void main(String[] args) {
        ArrayList<Transaction> input = new ArrayList<>();
        input.add(new Transaction("id1", 10.5, "10:00"));
        input.add(new Transaction("id2", 25.0, "09:30"));
        input.add(new Transaction("id3", 5.0, "10:15"));

        ArrayList<Transaction> bubbleList = new ArrayList<>(input);
        BubbleResult result = bubbleSortByFee(bubbleList);
        printList("BubbleSort (fees asc): ", bubbleList);
        System.out.println("Passes: " + result.passes + ", Swaps: " + result.swaps);

        ArrayList<Transaction> insertionList = new ArrayList<>(input);
        insertionSortByFeeThenTimestamp(insertionList);
        printList("InsertionSort (fee + ts): ", insertionList);

        List<Transaction> outliers = highFeeOutliers(insertionList);
        if (outliers.isEmpty()) {
            System.out.println("High-fee outliers: none");
        } else {
            printList("High-fee outliers: ", outliers);
        }
    }
}
