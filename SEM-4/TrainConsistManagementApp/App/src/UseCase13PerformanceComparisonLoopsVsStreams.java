import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13PerformanceComparisonLoopsVsStreams {
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

    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filteredBogies = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                filteredBogies.add(bogie);
            }
        }
        return filteredBogies;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(bogie -> bogie.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static List<Bogie> createBogieDataset(int size) {
        List<Bogie> bogies = new ArrayList<>();
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General"};

        for (int i = 0; i < size; i++) {
            String type = bogieTypes[i % bogieTypes.length];
            int capacity = 40 + (i % 80);
            bogies.add(new Bogie(type, capacity));
        }

        return bogies;
    }

    public static void main(String[] args) {
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");

        int capacityThreshold = 60;
        List<Bogie> bogies = createBogieDataset(200000);

        System.out.println("Total Bogies Prepared: " + bogies.size());
        System.out.println("Filtering Rule: Capacity > " + capacityThreshold);

        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = filterUsingLoop(bogies, capacityThreshold);
        long loopEnd = System.nanoTime();
        long loopElapsed = loopEnd - loopStart;

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = filterUsingStream(bogies, capacityThreshold);
        long streamEnd = System.nanoTime();
        long streamElapsed = streamEnd - streamStart;

        System.out.println("Loop Filtered Bogies: " + loopFiltered.size());
        System.out.println("Stream Filtered Bogies: " + streamFiltered.size());
        System.out.println("Execution Time (Loop): " + loopElapsed + " ns");
        System.out.println("Execution Time (Stream): " + streamElapsed + " ns");
        System.out.println("Results Match: " + (loopFiltered.size() == streamFiltered.size()));
        System.out.println("UC13 benchmarking completed...");
    }
}
