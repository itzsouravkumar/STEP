public class HotelSystem {
    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();

        booking.calculatePrice("Standard", 3);
        booking.calculatePrice("Suite", 2, 1.5);
        booking.calculatePrice("Deluxe", 4, 50, true);
        booking.calculatePrice("Suite", 2, 50, 200, true);
    }
}

class HotelBooking {
    public void calculatePrice(String roomType, int nights) {
        double rate = getBaseRate(roomType);
        double total = rate * nights;
        System.out.println("Standard Booking: Room = " + roomType + ", Nights = " + nights + ", Total = $" + total);
    }

    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double rate = getBaseRate(roomType);
        double total = rate * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking: Room = " + roomType + ", Nights = " + nights + ", Seasonal Multiplier = " + seasonalMultiplier + ", Total = $" + total);
    }

    public void calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        double rate = getBaseRate(roomType);
        double total = rate * nights;
        total -= corporateDiscount;
        if (mealPackage) total += 50;
        System.out.println("Corporate Booking: Room = " + roomType + ", Nights = " + nights + ", Corporate Discount = $" + corporateDiscount + ", Meal Package = " + (mealPackage ? "Yes" : "No") + ", Total = $" + total);
    }

    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, boolean catering) {
        double rate = getBaseRate(roomType);
        double total = rate * nights + decorationFee;
        if (catering) total += guestCount * 30;
        System.out.println("Wedding Package: Room = " + roomType + ", Nights = " + nights + ", Guests = " + guestCount + ", Decoration Fee = $" + decorationFee + ", Catering = " + (catering ? "Yes" : "No") + ", Total = $" + total);
    }

    private double getBaseRate(String roomType) {
        switch(roomType.toLowerCase()) {
            case "deluxe": return 200;
            case "suite": return 350;
            case "standard": return 100;
            default: return 100;
        }
    }
}