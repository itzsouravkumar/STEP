import java.util.Scanner;

class CustomNullPointerExample { // Renamed class to avoid conflict
    // Method to generate an exception
    public void generatingException() {
        String text = null;

        try {
            int stringSize = text.length(); // Causes NullPointerException
            System.out.println("Size of String--> " + stringSize);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    // Method to handle NullPointerException
    public void handlingNullPointerException() {
        String text = null;
        try {
            int stringLength = text.length(); // Causes NullPointerException
            System.out.println("Length of String--> " + stringLength);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception is caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomNullPointerExample example = new CustomNullPointerExample();

        example.generatingException();
        example.handlingNullPointerException();
    }
}