public class CarDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 25000);

        System.out.println("Car object: " + car);
        System.out.println("Class name: " + car.getClass().getName());
    }
}

class Car {
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[Brand: " + brand + ", Model: " + model + ", Price: $" + price + "]";
    }
}