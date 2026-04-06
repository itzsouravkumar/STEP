import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11ValidateTrainIdAndCargoCode {
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("UC11 Validate Train ID and Cargo Code -");
        System.out.println("Enter Train ID (Format: TRN-1234):");
        String trainId = scanner.nextLine();

        System.out.println("Enter Cargo Code (Format: PET-AB):");
        String cargoCode = scanner.nextLine();

        boolean trainIdValid = isValidTrainId(trainId);
        boolean cargoCodeValid = isValidCargoCode(cargoCode);

        System.out.println("Validation Results:");
        System.out.println("Train ID Valid: " + trainIdValid);
        System.out.println("Cargo Code Valid: " + cargoCodeValid);
        System.out.println("UC11 validation completed...");
    }
}
