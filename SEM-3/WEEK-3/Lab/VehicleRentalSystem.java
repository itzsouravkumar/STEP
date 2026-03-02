class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentedDays;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;
    private static int counter = 1;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalRentedDays = 0;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is not available.");
            return 0;
        }
        double amount = calculateRent(days);
        isAvailable = false;
        totalRentedDays += days;
        rentalDays += days;
        return amount;
    }

    public void returnVehicle() {
        if (isAvailable) {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        } else {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned successfully.");
        }
    }

    public double calculateRent(int days) {
        double amount = rentPerDay * days;
        totalRevenue += amount;
        return amount;
    }

    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Rent/Day: " + rentPerDay +
                ", Available: " + isAvailable +
                ", Total Rented Days: " + totalRentedDays);
    }

    private static String generateVehicleId() {
        return "VEH" + String.format("%03d", counter++);
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("===== " + companyName + " Stats =====");
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent Per Day: " + getAverageRentPerDay());
        System.out.println("============================\n");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("SuperRide Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Corolla", 1500);
        Vehicle v2 = new Vehicle("Honda", "Civic", 1800);
        Vehicle v3 = new Vehicle("Ford", "Mustang", 5000);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        double rent1 = v1.rentVehicle(5);
        System.out.println("Rent for v1: " + rent1);

        double rent2 = v2.rentVehicle(3);
        System.out.println("Rent for v2: " + rent2);

        v1.returnVehicle();
        v3.rentVehicle(2);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}