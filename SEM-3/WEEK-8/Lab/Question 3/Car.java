public class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started. Speed: " + speed + " km/h, Fuel: " + fuelType);
    }

    @Override
    public void serviceInfo() {
        System.out.println(model + " requires servicing every 6 months or 10,000 km.");
    }
}