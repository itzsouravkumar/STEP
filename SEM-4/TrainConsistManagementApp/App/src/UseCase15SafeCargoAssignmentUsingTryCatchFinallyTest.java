import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UseCase15SafeCargoAssignmentUsingTryCatchFinallyTest {
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

    public static void testCargo_SafeAssignment() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Cylindrical");

        boolean assigned = UseCase15SafeCargoAssignmentUsingTryCatchFinally
                .assignCargoSafely(bogie, "Petroleum");

        assertTrue(assigned, "Safe cargo assignment should succeed.");
        assertEquals("Petroleum", bogie.getCargo(),
                "Cylindrical bogie should store assigned petroleum cargo.");
    }

    public static void testCargo_UnsafeAssignmentHandled() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Rectangular");

        boolean assigned = UseCase15SafeCargoAssignmentUsingTryCatchFinally
                .assignCargoSafely(bogie, "Petroleum");

        assertTrue(!assigned, "Unsafe assignment should be handled and reported as failure.");
    }

    public static void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Rectangular");

        UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum");
        assertEquals("Unassigned", bogie.getCargo(),
                "Unsafe cargo should not be stored after failed assignment.");
    }

    public static void testCargo_ProgramContinuesAfterException() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie unsafe =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Rectangular");
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie safe =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Open");

        boolean first = UseCase15SafeCargoAssignmentUsingTryCatchFinally
                .assignCargoSafely(unsafe, "Petroleum");
        boolean second = UseCase15SafeCargoAssignmentUsingTryCatchFinally
                .assignCargoSafely(safe, "Coal");

        assertTrue(!first, "First assignment should fail safely.");
        assertTrue(second, "Program should continue and complete next valid assignment.");
        assertEquals("Coal", safe.getCargo(),
                "Second valid assignment should succeed after exception handling.");
    }

    public static void testCargo_FinallyBlockExecution() {
        UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie bogie =
                new UseCase15SafeCargoAssignmentUsingTryCatchFinally.GoodsBogie("Rectangular");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            UseCase15SafeCargoAssignmentUsingTryCatchFinally.assignCargoSafely(bogie, "Petroleum");
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Cargo assignment validation completed for: Rectangular"),
                "Finally block completion log should always execute.");
    }

    public static void main(String[] args) {
        System.out.println("Running UC15 test cases...");

        testCargo_SafeAssignment();
        testCargo_UnsafeAssignmentHandled();
        testCargo_CargoNotAssignedAfterFailure();
        testCargo_ProgramContinuesAfterException();
        testCargo_FinallyBlockExecution();

        System.out.println("All UC15 test cases passed successfully.");
    }
}
