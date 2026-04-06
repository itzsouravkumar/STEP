import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9GroupBogiesByType {
    static class Bogie {
        private final String type;
        private final int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    public static void main(String[] args) {
        System.out.println("UC9 - Group Bogies by Type");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        Map<String, List<Bogie>> grouped = groupByType(bogies);
        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie bogie : entry.getValue()) {
                System.out.println("Capacity -> " + bogie.getCapacity());
            }
        }

        System.out.println("UC9 grouping completed...");
    }
}
