import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8FilterPassengerBogiesUsingStreams {
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

    public static List<Bogie> filterByCapacityGreaterThan(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("UC8 Filter Passenger Bogies Using Streams -");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        List<Bogie> filtered = filterByCapacityGreaterThan(bogies, 60);
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie bogie : filtered) {
            System.out.println(bogie);
        }

        System.out.println("UC8 filtering completed...");
    }
}
