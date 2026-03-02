public class Vehicle {
    // TODO: Create protected instance variables
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    // TODO: Create constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // TODO: Create common methods
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle: " + year + " " + make + " " + model + ", Fuel: " + fuelLevel);
    }

    // Subclasses
    static class Car extends Vehicle {
        public Car(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }

        @Override
        public void displayVehicleInfo() {
            System.out.println("Car -> " + year + " " + make + " " + model + ", Fuel: " + fuelLevel);
        }
    }

    static class Truck extends Vehicle {
        public Truck(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }

        @Override
        public void displayVehicleInfo() {
            System.out.println("Truck -> " + year + " " + make + " " + model + ", Fuel: " + fuelLevel);
        }
    }

    static class Motorcycle extends Vehicle {
        public Motorcycle(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }

        @Override
        public void displayVehicleInfo() {
            System.out.println("Motorcycle -> " + year + " " + make + " " + model + ", Fuel: " + fuelLevel);
        }
    }

    public static void main(String[] args) {
        // TODO: Create different types of vehicles (Car, Truck, Motorcycle)
        Vehicle car = new Car("Toyota", "Corolla", 2020, 50);
        Vehicle truck = new Truck("Ford", "F-150", 2019, 80);
        Vehicle motorcycle = new Motorcycle("Yamaha", "R15", 2022, 20);

        // TODO: Show how the same Vehicle class can be reused
        car.startVehicle();
        truck.startVehicle();
        motorcycle.startVehicle();

        // TODO: Create an array of Vehicle objects
        Vehicle[] vehicles = {car, truck, motorcycle};

        // TODO: Demonstrate polymorphic behavior
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();  // Calls overridden method depending on object type
            v.refuel(10);
        }

        // TODO: In comments, explain:
        // - How does this show reusability?
        //   -> We reuse the Vehicle class as a parent, and extend it for Car, Truck, Motorcycle without rewriting common code.
        //
        // - How could this be extended for new vehicle types?
        //   -> Just create a new class (e.g., Bus, ElectricCar) that extends Vehicle and override methods if needed.
        //
        // - What are the benefits over writing separate classes?
        //   -> Avoids duplication, makes code maintainable, and allows polymorphism (same method works differently for each vehicle).
    }
}