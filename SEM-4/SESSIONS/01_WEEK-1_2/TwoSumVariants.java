import java.util.*;

class Transaction {
    int id;
    int amount;
    String merchant;
    String time;
    String account;

    public Transaction(int id, int amount, String merchant, String time, String account) {
        this.id = id;
        this.amount = amount;
        this.merchant = merchant;
        this.time = time;
        this.account = account;
    }

    @Override
    public String toString() {
        return "id:" + id;
    }
}

public class TwoSumVariants {

    public static List<String> findTwoSum(List<Transaction> transactions, int target) {
        Map<Integer, Transaction> map = new HashMap<>();
        List<String> results = new ArrayList<>();
        
        for (Transaction t : transactions) {
            int complement = target - t.amount;
            if (map.containsKey(complement)) {
                results.add("[(" + map.get(complement) + ", " + t + ")]");
            }
            map.put(t.amount, t);
        }
        return results;
    }

    public static List<String> detectDuplicates(List<Transaction> transactions) {
        // key format: "amount_merchant"
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        for (Transaction t : transactions) {
            String key = t.amount + "_" + t.merchant;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
        }

        for (List<Transaction> group : map.values()) {
            if (group.size() > 1) {
                Set<String> accounts = new HashSet<>();
                for (Transaction t : group) {
                    accounts.add(t.account);
                }
                if (accounts.size() > 1) {
                    duplicates.add("{amount:" + group.get(0).amount + ", merchant:\"" + group.get(0).merchant + "\", accounts:" + accounts + "}");
                }
            }
        }
        return duplicates;
    }
    
    // Simple 3-sum variant for demonstration (can be extended to K-Sum)
    public static List<String> findThreeSum(List<Transaction> transactions, int target) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < transactions.size() - 2; i++) {
            Map<Integer, Transaction> map = new HashMap<>();
            int currentTarget = target - transactions.get(i).amount;
            
            for (int j = i + 1; j < transactions.size(); j++) {
                int complement = currentTarget - transactions.get(j).amount;
                if (map.containsKey(complement)) {
                    results.add("[(" + transactions.get(i) + ", " + map.get(complement) + ", " + transactions.get(j) + ")]");
                }
                map.put(transactions.get(j).amount, transactions.get(j));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<Transaction> txns = Arrays.asList(
            new Transaction(1, 500, "Store A", "10:00", "acc1"),
            new Transaction(2, 300, "Store B", "10:15", "acc2"),
            new Transaction(3, 200, "Store C", "10:30", "acc3"),
            new Transaction(4, 500, "Store A", "10:45", "acc2") // Duplicate amount and merchant, different account
        );

        System.out.println("findTwoSum(target=500) -> " + findTwoSum(txns, 500));
        System.out.println("detectDuplicates() -> " + detectDuplicates(txns));
        System.out.println("findKSum(k=3, target=1000) -> " + findThreeSum(txns, 1000));
    }
}
