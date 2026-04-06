import java.util.ArrayList;
import java.util.List;

public class UseCase10CountTotalSeatsInTrain {
    static class Bogie {
        private final String name;
        private final int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static int totalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("UC10 Count Total Seats in Train -");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        int total = totalSeatingCapacity(bogies);
        System.out.println("Total Seating Capacity of Train: " + total);
        System.out.println("UC10 aggregation completed...");
    }
}
