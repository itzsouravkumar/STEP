public class UseCase19BinarySearchForBogieIdOptimizedSearchingTest {
    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    public static void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG309");
        assertTrue(result, "Existing bogie ID should be found.");
    }

    public static void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG999");
        assertFalse(result, "Non-existing bogie ID should not be found.");
    }

    public static void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG101");
        assertTrue(result, "First element match should return true.");
    }

    public static void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG550");
        assertTrue(result, "Last element match should return true.");
    }

    public static void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG101");
        assertTrue(result, "Single element array should return true when match exists.");
    }

    public static void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG101");
        assertFalse(result, "Empty array should return false.");
    }

    public static void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        boolean result = UseCase19BinarySearchForBogieIdOptimizedSearching
                .binarySearch(bogieIds, "BG205");
        assertTrue(result, "Unsorted input should be sorted internally and return true.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC19 test cases...");

        testBinarySearch_BogieFound();
        testBinarySearch_BogieNotFound();
        testBinarySearch_FirstElementMatch();
        testBinarySearch_LastElementMatch();
        testBinarySearch_SingleElementArray();
        testBinarySearch_EmptyArray();
        testBinarySearch_UnsortedInputHandled();

        System.out.println("All UC19 test cases passed successfully.");
    }
}
