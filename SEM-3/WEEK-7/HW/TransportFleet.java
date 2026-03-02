public class TransportFleet {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Bus("CityLine", 50);
        fleet[1] = new Taxi("QuickCab");
        fleet[2] = new Train("ExpressTrain", 10);
        fleet[3] = new Bike("EcoBike");

        for (Vehicle v : fleet) {
            v.dispatch();
        }
    }
}

class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void dispatch() {
        System.out.println(name + " is being dispatched in a general way.");
    }
}

class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String name, int passengerCapacity) {
        super(name);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void dispatch() {
        System.out.println(name + " bus is running on its fixed route with capacity of " + passengerCapacity + " passengers.");
    }
}

class Taxi extends Vehicle {
    public Taxi(String name) {
        super(name);
    }

    @Override
    public void dispatch() {
        System.out.println(name + " taxi is providing door-to-door service. Fare will be calculated by distance.");
    }
}

class Train extends Vehicle {
    private int cars;

    public Train(String name, int cars) {
        super(name);
        this.cars = cars;
    }

    @Override
    public void dispatch() {
        System.out.println(name + " train is running on schedule with " + cars + " cars.");
    }
}

class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void dispatch() {
        System.out.println(name + " bike is available for short eco-friendly trips.");
    }
}