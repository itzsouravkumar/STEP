import java.util.ArrayList;
import java.util.List;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14HandleInvalidBogieCapacity {
    static class PassengerBogie {
        private final String type;
        private final int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC14 - Handle Invalid Bogie Capacity (Custom Exception)");

        List<PassengerBogie> consist = new ArrayList<>();

        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            consist.add(sleeper);
            System.out.println("Added: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("Error while adding Sleeper bogie: " + e.getMessage());
        }

        try {
            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            consist.add(invalid);
            System.out.println("Added: " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Error while adding AC Chair bogie: " + e.getMessage());
        }

        System.out.println("Final Passenger Bogies in Train:");
        for (PassengerBogie bogie : consist) {
            System.out.println(bogie);
        }
        System.out.println("UC14 exception handling completed...");
    }
}
