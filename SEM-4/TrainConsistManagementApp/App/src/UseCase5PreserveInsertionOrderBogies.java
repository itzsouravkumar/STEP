import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5PreserveInsertionOrderBogies {
    public static void main(String[] args) {
        System.out.println("UC5 Preserve Insertion Order of Bogies");

        Set<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("UC5 formation setup completed...");
    }
}
