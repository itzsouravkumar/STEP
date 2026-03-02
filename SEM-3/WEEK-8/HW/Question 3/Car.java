public class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car engine started.");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueled with petrol.");
    }
}