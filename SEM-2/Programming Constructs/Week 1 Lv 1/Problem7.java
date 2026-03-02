public class Problem7 {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double kmToMiles = 0.621371;
        double pi = 3.14;

        double volumeKm3 = (4.0 / 3.0) * pi * (radiusKm * radiusKm * radiusKm);
        double volumeMiles3 = volumeKm3 * (kmToMiles * kmToMiles * kmToMiles);

        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 + " and in cubic miles is " + volumeMiles3 + ".");
    }
}
