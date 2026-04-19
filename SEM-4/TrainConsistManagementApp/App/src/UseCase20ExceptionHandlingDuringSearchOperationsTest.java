public class UseCase20ExceptionHandlingDuringSearchOperationsTest {
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

    public static void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        try {
            UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(bogieIds, "BG101");
            throw new AssertionError("Expected IllegalStateException for empty data.");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().equals("Cannot perform search: no bogies available in train."),
                    "Exception message should explain empty train state.");
        }
    }

    public static void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        boolean result = UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(bogieIds, "BG101");
        assertTrue(result, "Search should execute when data exists.");
    }

    public static void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(bogieIds, "BG205");
        assertTrue(result, "Existing bogie ID should be found after validation.");
    }

    public static void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(bogieIds, "BG999");
        assertFalse(result, "Non-existing bogie ID should return false.");
    }

    public static void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        boolean result = UseCase20ExceptionHandlingDuringSearchOperations.searchBogieId(bogieIds, "BG101");
        assertTrue(result, "Single element valid search should return true.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC20 test cases...");

        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();

        System.out.println("All UC20 test cases passed successfully.");
    }
}
