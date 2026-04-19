import java.util.Arrays;

public class UseCase18LinearSearchForBogieIdArrayBasedSearching {
    public static boolean linearSearch(String[] bogieIds, String searchKey) {
        for (String bogieId : bogieIds) {
            if (bogieId.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC18 - Linear Search for Bogie ID (Array-Based Searching)");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        boolean found = linearSearch(bogieIds, searchKey);
        if (found) {
            System.out.println("Result: Bogie ID found.");
        } else {
            System.out.println("Result: Bogie ID not found.");
        }

        System.out.println("UC18 linear search completed...");
    }
}
