import java.util.Arrays;

public class Problem2ClientRiskScoreRanking {

    static class Client {
        String clientId;
        int riskScore;
        double accountBalance;

        Client(String clientId, int riskScore, double accountBalance) {
            this.clientId = clientId;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        @Override
        public String toString() {
            return clientId + "(" + riskScore + ", $" + accountBalance + ")";
        }
    }

    static int bubbleSortRiskAsc(Client[] clients) {
        int swaps = 0;
        int n = clients.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return swaps;
    }

    static void insertionSortRiskDescBalanceAsc(Client[] clients) {
        for (int i = 1; i < clients.length; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && compareForDesc(clients[j], key) > 0) {
                clients[j + 1] = clients[j];
                j--;
            }

            clients[j + 1] = key;
        }
    }

    static int compareForDesc(Client a, Client b) {
        if (a.riskScore != b.riskScore) {
            return Integer.compare(b.riskScore, a.riskScore);
        }
        return Double.compare(a.accountBalance, b.accountBalance);
    }

    static void printTopRisks(Client[] clients, int topK) {
        int limit = Math.min(topK, clients.length);
        System.out.println("Top " + limit + " highest risk clients:");
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + clients[i]);
        }
    }

    public static void main(String[] args) {
        Client[] input = {
            new Client("clientC", 80, 5000),
            new Client("clientA", 20, 12000),
            new Client("clientB", 50, 8000)
        };

        Client[] bubbleArr = Arrays.copyOf(input, input.length);
        int swaps = bubbleSortRiskAsc(bubbleArr);
        System.out.println("Bubble (asc risk): " + Arrays.toString(bubbleArr));
        System.out.println("Swaps: " + swaps);

        Client[] insertionArr = Arrays.copyOf(input, input.length);
        insertionSortRiskDescBalanceAsc(insertionArr);
        System.out.println("Insertion (desc risk + balance): " + Arrays.toString(insertionArr));

        printTopRisks(insertionArr, 10);
    }
}
