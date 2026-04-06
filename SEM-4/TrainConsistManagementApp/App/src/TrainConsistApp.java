import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Train initialized successfully...");

        List<String> consist = new ArrayList<>();

        System.out.println("Initial Bogie Count: " + consist.size());
        System.out.println("Current Train Consist: " + consist);
        System.out.println("System ready for operations...");
    }
}
