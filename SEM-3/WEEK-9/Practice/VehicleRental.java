package Practice;
public class VehicleRental {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println(v1);

        Vehicle v2 = new Vehicle("DL05CD6789", "SUV", 2500);
        System.out.println(v2);
    }
}

class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;

    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }

    @Override
    public String toString() {
        return "Vehicle: " + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getType() {
        return type;
    }

    public double getRatePerDay() {
        return ratePerDay;
    }
}
