import java.util.Arrays;

public class UseCase20ExceptionHandlingDuringSearchOperations {
    public static boolean searchBogieId(String[] bogieIds, String searchKey) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot perform search: no bogies available in train.");
        }

        for (String bogieId : bogieIds) {
            if (bogieId.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC20 - Exception Handling During Search Operations");

        String[] bogieIds = {"BG101", "BG205", "BG309"};
        String searchKey = "BG205";

        System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        try {
            boolean found = searchBogieId(bogieIds, searchKey);
            if (found) {
                System.out.println("Result: Bogie ID found.");
            } else {
                System.out.println("Result: Bogie ID not found.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Search Error: " + e.getMessage());
        }

        System.out.println("UC20 search validation completed...");
    }
}
