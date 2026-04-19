public class UseCase18LinearSearchForBogieIdArrayBasedSearchingTest {
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

    public static void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18LinearSearchForBogieIdArrayBasedSearching
                .linearSearch(bogieIds, "BG309");
        assertTrue(result, "Existing bogie ID should be found.");
    }

    public static void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18LinearSearchForBogieIdArrayBasedSearching
                .linearSearch(bogieIds, "BG999");
        assertFalse(result, "Non-existing bogie ID should not be found.");
    }

    public static void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18LinearSearchForBogieIdArrayBasedSearching
                .linearSearch(bogieIds, "BG101");
        assertTrue(result, "First element match should return true.");
    }

    public static void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase18LinearSearchForBogieIdArrayBasedSearching
                .linearSearch(bogieIds, "BG550");
        assertTrue(result, "Last element match should return true.");
    }

    public static void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        boolean result = UseCase18LinearSearchForBogieIdArrayBasedSearching
                .linearSearch(bogieIds, "BG101");
        assertTrue(result, "Single element array search should return true.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC18 test cases...");

        testSearch_BogieFound();
        testSearch_BogieNotFound();
        testSearch_FirstElementMatch();
        testSearch_LastElementMatch();
        testSearch_SingleElementArray();

        System.out.println("All UC18 test cases passed successfully.");
    }
}
