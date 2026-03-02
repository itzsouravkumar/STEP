public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        double kilometers = 5.0;
        double miles = 3.1;
        double meters = 10.0;
        double feet = 32.8;

        System.out.println(kilometers + " kilometers is " + convertKmToMiles(kilometers) + " miles.");
        System.out.println(miles + " miles is " + convertMilesToKm(miles) + " kilometers.");
        System.out.println(meters + " meters is " + convertMetersToFeet(meters) + " feet.");
        System.out.println(feet + " feet is " + convertFeetToMeters(feet) + " meters.");
    }
}