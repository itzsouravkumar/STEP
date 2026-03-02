import java.time.Year;

public class Car {
    // TODO: Define instance variables (attributes)
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    // TODO: Create a constructor that initializes all attributes
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // by default engine is off
    }

    // TODO: Create instance methods

    // - startEngine() - sets isRunning to true, prints message
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " engine started.");
        } else {
            System.out.println(brand + " " + model + " is already running.");
        }
    }

    // - stopEngine() - sets isRunning to false, prints message
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " engine stopped.");
        } else {
            System.out.println(brand + " " + model + " is already off.");
        }
    }

    // - displayInfo() - prints all car information
    public void displayInfo() {
        System.out.println("Car Info: " + brand + " " + model + ", Year: " + year + ", Color: " + color + ", Running: " + isRunning);
    }

    // - getAge() - returns current year minus car year
    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - year;
    }

    public static void main(String[] args) {
        // TODO: Create 3 different Car objects with different attributes
        Car car1 = new Car("Toyota", "Corolla", 2015, "White");
        Car car2 = new Car("Honda", "Civic", 2018, "Black");
        Car car3 = new Car("Ford", "Mustang", 2020, "Red");

        // TODO: Demonstrate calling methods on each object
        car1.displayInfo();
        car1.startEngine();
        car1.stopEngine();
        System.out.println("Car1 Age: " + car1.getAge() + " years\n");

        car2.displayInfo();
        car2.startEngine();
        car2.startEngine(); // trying again to show state
        System.out.println("Car2 Age: " + car2.getAge() + " years\n");

        car3.displayInfo();
        car3.startEngine();
        car3.stopEngine();
        System.out.println("Car3 Age: " + car3.getAge() + " years\n");

        // TODO: Show how each object maintains its own state
        // Example: car1 can be stopped while car2 is still running,
        // showing that each car object has its own "isRunning" state.

        // TODO: Explain in comments: How is this similar to real-world cars?
        // -> Each real car has its own attributes (brand, model, year, color).
        // -> Each car’s engine can be started or stopped independently.
        // -> In programming, objects (like car1, car2, car3) work the same way,
        //    each maintaining its own state and behavior.
    }
}
