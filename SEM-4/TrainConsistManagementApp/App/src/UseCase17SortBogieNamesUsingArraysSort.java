import java.util.Arrays;

public class UseCase17SortBogieNamesUsingArraysSort {
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("Sorted Bogie Names:   " + Arrays.toString(bogieNames));
        System.out.println("UC17 array sorting completed...");
    }
}
