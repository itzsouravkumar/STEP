public class UseCase17SortBogieNamesUsingArraysSortTest {
    private static void assertArrayEquals(String[] expected, String[] actual, String message) {
        if (expected.length != actual.length) {
            throw new AssertionError(message + " Length mismatch.");
        }
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                throw new AssertionError(message + " Mismatch at index " + i);
            }
        }
    }

    public static void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(input);
        assertArrayEquals(expected, input, "Basic alphabetical sorting failed.");
    }

    public static void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(input);
        assertArrayEquals(expected, input, "Unsorted input handling failed.");
    }

    public static void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(input);
        assertArrayEquals(expected, input, "Already sorted array should remain unchanged.");
    }

    public static void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(input);
        assertArrayEquals(expected, input, "Duplicate bogie names handling failed.");
    }

    public static void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        UseCase17SortBogieNamesUsingArraysSort.sortBogieNames(input);
        assertArrayEquals(expected, input, "Single element array should remain unchanged.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC17 test cases...");

        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();

        System.out.println("All UC17 test cases passed successfully.");
    }
}
