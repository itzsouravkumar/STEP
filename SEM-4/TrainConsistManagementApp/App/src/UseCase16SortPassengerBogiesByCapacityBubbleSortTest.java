public class UseCase16SortPassengerBogiesByCapacityBubbleSortTest {
    private static void assertArrayEquals(int[] expected, int[] actual, String message) {
        if (expected.length != actual.length) {
            throw new AssertionError(message + " Length mismatch.");
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionError(message + " Mismatch at index " + i);
            }
        }
    }

    public static void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16SortPassengerBogiesByCapacityBubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Basic sorting failed.");
    }

    public static void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16SortPassengerBogiesByCapacityBubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Already sorted array should remain unchanged.");
    }

    public static void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        UseCase16SortPassengerBogiesByCapacityBubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Duplicate values sorting failed.");
    }

    public static void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        UseCase16SortPassengerBogiesByCapacityBubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Single element array should remain unchanged.");
    }

    public static void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        UseCase16SortPassengerBogiesByCapacityBubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "All equal values should remain unchanged.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC16 test cases...");

        testSort_BasicSorting();
        testSort_AlreadySortedArray();
        testSort_DuplicateValues();
        testSort_SingleElementArray();
        testSort_AllEqualValues();

        System.out.println("All UC16 test cases passed successfully.");
    }
}
