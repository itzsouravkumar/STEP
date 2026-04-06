import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7SortBogiesByCapacity {
    private static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
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

    public static void main(String[] args) {
        System.out.println("UC7 Sort Bogies by Capacity (Comparator)");

        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        System.out.println("UC7 sorting completed...");
    }
}
