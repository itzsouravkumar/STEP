import java.util.ArrayList;
import java.util.List;

public class UseCase14HandleInvalidBogieCapacityTest {
    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " Expected: " + expected + ", Actual: " + actual);
        }
    }

    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void testException_ValidCapacityCreation() throws InvalidCapacityException {
        UseCase14HandleInvalidBogieCapacity.PassengerBogie bogie =
                new UseCase14HandleInvalidBogieCapacity.PassengerBogie("Sleeper", 72);
        assertTrue(bogie != null, "Valid capacity bogie should be created successfully.");
    }

    public static void testException_NegativeCapacityThrowsException() {
        try {
            new UseCase14HandleInvalidBogieCapacity.PassengerBogie("AC Chair", -10);
            throw new AssertionError("Negative capacity should throw InvalidCapacityException.");
        } catch (InvalidCapacityException e) {
            assertTrue(true, "Exception thrown as expected.");
        }
    }

    public static void testException_ZeroCapacityThrowsException() {
        try {
            new UseCase14HandleInvalidBogieCapacity.PassengerBogie("First Class", 0);
            throw new AssertionError("Zero capacity should throw InvalidCapacityException.");
        } catch (InvalidCapacityException e) {
            assertTrue(true, "Exception thrown as expected.");
        }
    }

    public static void testException_ExceptionMessageValidation() {
        try {
            new UseCase14HandleInvalidBogieCapacity.PassengerBogie("General", 0);
            throw new AssertionError("Exception should have been thrown for invalid capacity.");
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage(),
                    "Exception message validation failed.");
        }
    }

    public static void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        UseCase14HandleInvalidBogieCapacity.PassengerBogie bogie =
                new UseCase14HandleInvalidBogieCapacity.PassengerBogie("Sleeper", 70);
        assertEquals("Sleeper", bogie.getType(), "Bogie type should match input.");
        assertEquals(70, bogie.getCapacity(), "Bogie capacity should match input.");
    }

    public static void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        List<UseCase14HandleInvalidBogieCapacity.PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase14HandleInvalidBogieCapacity.PassengerBogie("Sleeper", 72));
        bogies.add(new UseCase14HandleInvalidBogieCapacity.PassengerBogie("AC Chair", 56));
        bogies.add(new UseCase14HandleInvalidBogieCapacity.PassengerBogie("First Class", 24));

        assertEquals(3, bogies.size(), "Multiple valid bogies should be created successfully.");
    }

    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("Running UC14 test cases...");

        testException_ValidCapacityCreation();
        testException_NegativeCapacityThrowsException();
        testException_ZeroCapacityThrowsException();
        testException_ExceptionMessageValidation();
        testException_ObjectIntegrityAfterCreation();
        testException_MultipleValidBogiesCreation();

        System.out.println("All UC14 test cases passed successfully.");
    }
}
