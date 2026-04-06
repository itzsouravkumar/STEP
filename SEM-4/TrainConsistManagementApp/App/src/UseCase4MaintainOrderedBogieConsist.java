import java.util.LinkedList;

public class UseCase4MaintainOrderedBogieConsist {
    public static void main(String[] args) {
        System.out.println("UC4 Maintain Ordered Bogie Consist -");
        System.out.println("=");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("UC4 ordered consist operations completed...");
    }
}
