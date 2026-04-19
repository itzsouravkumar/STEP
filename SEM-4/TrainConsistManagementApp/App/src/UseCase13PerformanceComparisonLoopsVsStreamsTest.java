import java.util.ArrayList;
import java.util.List;

public class UseCase13PerformanceComparisonLoopsVsStreamsTest {
    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void testLoopFilteringLogic() {
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("Sleeper", 72));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("AC Chair", 56));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("First Class", 24));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("General", 90));

        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> filtered =
                UseCase13PerformanceComparisonLoopsVsStreams.filterUsingLoop(bogies, 60);

        assertEquals(2, filtered.size(), "Loop-based filtering logic failed.");
    }

    public static void testStreamFilteringLogic() {
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("Sleeper", 72));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("AC Chair", 56));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("First Class", 24));
        bogies.add(new UseCase13PerformanceComparisonLoopsVsStreams.Bogie("General", 90));

        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> filtered =
                UseCase13PerformanceComparisonLoopsVsStreams.filterUsingStream(bogies, 60);

        assertEquals(2, filtered.size(), "Stream-based filtering logic failed.");
    }

    public static void testLoopAndStreamResultsMatch() {
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> bogies =
                UseCase13PerformanceComparisonLoopsVsStreams.createBogieDataset(1000);

        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> loopFiltered =
                UseCase13PerformanceComparisonLoopsVsStreams.filterUsingLoop(bogies, 60);
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> streamFiltered =
                UseCase13PerformanceComparisonLoopsVsStreams.filterUsingStream(bogies, 60);

        assertEquals(loopFiltered.size(), streamFiltered.size(),
                "Loop and stream results should have identical size.");
    }

    public static void testExecutionTimeMeasurement() {
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> bogies =
                UseCase13PerformanceComparisonLoopsVsStreams.createBogieDataset(200000);

        long start = System.nanoTime();
        UseCase13PerformanceComparisonLoopsVsStreams.filterUsingLoop(bogies, 60);
        long end = System.nanoTime();
        long elapsed = end - start;

        assertTrue(elapsed > 0, "Execution time should be greater than zero.");
    }

    public static void testLargeDatasetProcessing() {
        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> bogies =
                UseCase13PerformanceComparisonLoopsVsStreams.createBogieDataset(500000);

        List<UseCase13PerformanceComparisonLoopsVsStreams.Bogie> filtered =
                UseCase13PerformanceComparisonLoopsVsStreams.filterUsingStream(bogies, 60);

        assertTrue(!filtered.isEmpty(), "Large dataset processing should return non-empty results.");
        assertTrue(filtered.size() < bogies.size(),
                "Filtered size should be smaller than source dataset.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC13 test cases...");

        testLoopFilteringLogic();
        testStreamFilteringLogic();
        testLoopAndStreamResultsMatch();
        testExecutionTimeMeasurement();
        testLargeDatasetProcessing();

        System.out.println("All UC13 test cases passed successfully.");
    }
}
