import java.util.*;

// Base Vehicle class
abstract class Vehicle {
    String vehicleId;
    String brand;
    String model;
    int year;
    double mileage;
    String fuelType;
    String currentStatus; // Available, In Service, On Trip
    Driver assignedDriver;

    static int totalVehicles = 0;
    static double fleetValue = 0.0;
    static String companyName = "TransFleet Corp";
    static double totalFuelConsumption = 0.0;

    double baseValue;
    double runningCost;
    double maintenanceCost;

    public Vehicle(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double baseValue) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.baseValue = baseValue;
        this.currentStatus = "Available";
        this.assignedDriver = null;
        totalVehicles++;
        fleetValue += baseValue;
    }

    public void assignDriver(Driver driver) {
        if (assignedDriver == null) {
            assignedDriver = driver;
            driver.assignedVehicle = this;
            System.out.println(driver.driverName + " assigned to " + brand + " " + model);
        } else {
            System.out.println("Vehicle already has a driver assigned.");
        }
    }

    public void scheduleMaintenance(double cost) {
        maintenanceCost += cost;
        currentStatus = "In Service";
        System.out.println(brand + " " + model + " scheduled for maintenance. Cost: " + cost);
    }

    public void completeMaintenance() {
        currentStatus = "Available";
        System.out.println(brand + " " + model + " is now available after maintenance.");
    }

    public void updateMileage(double km, double fuelUsed) {
        mileage += km;
        totalFuelConsumption += fuelUsed;
        System.out.println(brand + " " + model + " mileage updated: +" + km + " km.");
    }

    public boolean checkServiceDue() {
        return mileage > 10000; // simple condition
    }

    public abstract double calculateRunningCost();

    public void displayVehicleInfo() {
        System.out.println("\n--- Vehicle Info ---");
        System.out.println("ID: " + vehicleId + " | Brand: " + brand + " | Model: " + model);
        System.out.println("Year: " + year + " | Mileage: " + mileage + " km | Fuel: " + fuelType);
        System.out.println("Status: " + currentStatus + " | Driver: " + (assignedDriver != null ? assignedDriver.driverName : "None"));
    }
}

// Car class
class Car extends Vehicle {
    int seats;

    public Car(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double baseValue, int seats) {
        super(vehicleId, brand, model, year, mileage, fuelType, baseValue);
        this.seats = seats;
    }

    @Override
    public double calculateRunningCost() {
        runningCost = mileage * 0.5; // example calculation
        return runningCost;
    }
}

// Bus class
class Bus extends Vehicle {
    int seatingCapacity;

    public Bus(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double baseValue, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, baseValue);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public double calculateRunningCost() {
        runningCost = mileage * 0.8;
        return runningCost;
    }
}

// Truck class
class Truck extends Vehicle {
    double loadCapacity;

    public Truck(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double baseValue, double loadCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, baseValue);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRunningCost() {
        runningCost = mileage * 1.2;
        return runningCost;
    }
}

// Driver class
class Driver {
    String driverId;
    String driverName;
    String licenseType;
    Vehicle assignedVehicle;
    int totalTrips;

    public Driver(String driverId, String driverName, String licenseType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.assignedVehicle = null;
        this.totalTrips = 0;
    }

    public void completeTrip(double distance, double fuelUsed) {
        if (assignedVehicle != null) {
            assignedVehicle.updateMileage(distance, fuelUsed);
            totalTrips++;
            System.out.println(driverName + " completed trip of " + distance + " km in " + assignedVehicle.model);
        } else {
            System.out.println(driverName + " is not assigned to any vehicle.");
        }
    }
}

// Static report methods
class FleetReports {
    public static void getFleetUtilization(List<Vehicle> vehicles) {
        int available = 0, inService = 0, onTrip = 0;
        for (Vehicle v : vehicles) {
            switch (v.currentStatus) {
                case "Available": available++; break;
                case "In Service": inService++; break;
                case "On Trip": onTrip++; break;
            }
        }
        System.out.println("\n--- Fleet Utilization ---");
        System.out.println("Available: " + available + " | In Service: " + inService + " | On Trip: " + onTrip);
    }

    public static double calculateTotalMaintenanceCost(List<Vehicle> vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.maintenanceCost;
        System.out.println("Total Maintenance Cost: " + total);
        return total;
    }

    public static void getVehiclesByType(List<Vehicle> vehicles, String type) {
        System.out.println("\nVehicles of type " + type + ":");
        for (Vehicle v : vehicles) {
            if (type.equalsIgnoreCase("Car") && v instanceof Car) v.displayVehicleInfo();
            if (type.equalsIgnoreCase("Bus") && v instanceof Bus) v.displayVehicleInfo();
            if (type.equalsIgnoreCase("Truck") && v instanceof Truck) v.displayVehicleInfo();
        }
    }
}

public class FleetManagementSystem {
    public static void main(String[] args) {
        // Vehicles
        Car c1 = new Car("V001", "Toyota", "Corolla", 2020, 9500, "Petrol", 1200000, 5);
        Bus b1 = new Bus("V002", "Volvo", "B9R", 2018, 15000, "Diesel", 5000000, 45);
        Truck t1 = new Truck("V003", "Tata", "Heavy", 2019, 20000, "Diesel", 3500000, 20);

        List<Vehicle> fleet = Arrays.asList(c1, b1, t1);

        // Drivers
        Driver d1 = new Driver("D001", "Alice", "Car");
        Driver d2 = new Driver("D002", "Bob", "Heavy");
        Driver d3 = new Driver("D003", "Charlie", "Bus");

        // Assign drivers
        c1.assignDriver(d1);
        b1.assignDriver(d3);
        t1.assignDriver(d2);

        // Trips
        d1.completeTrip(200, 15);
        d3.completeTrip(500, 80);
        d2.completeTrip(300, 50);

        // Maintenance
        b1.scheduleMaintenance(20000);
        b1.completeMaintenance();

        // Reports
        FleetReports.getFleetUtilization(fleet);
        FleetReports.calculateTotalMaintenanceCost(fleet);
        FleetReports.getVehiclesByType(fleet, "Bus");

        System.out.println("\nTotal Vehicles: " + Vehicle.totalVehicles);
        System.out.println("Fleet Value: " + Vehicle.fleetValue);
        System.out.println("Total Fuel Consumption: " + Vehicle.totalFuelConsumption);
    }
}