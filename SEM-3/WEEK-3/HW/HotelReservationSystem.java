import java.util.Scanner;

class Room {
    String roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    int maxOccupancy;
    int timesBooked; // for popularity tracking

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.maxOccupancy = maxOccupancy;
        this.timesBooked = 0;
    }

    public void markBooked() {
        isAvailable = false;
        timesBooked++;
    }

    public void markAvailable() {
        isAvailable = true;
    }

    public void displayRoomInfo() {
        System.out.println("Room " + roomNumber + " | Type: " + roomType +
                " | Price: " + pricePerNight +
                " | Available: " + isAvailable +
                " | Max Occupancy: " + maxOccupancy);
    }
}

class Guest {
    String guestId;
    String guestName;
    String phoneNumber;
    String email;
    String[] bookingHistory;
    int bookingCount;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[10];
        this.bookingCount = 0;
    }

    public void addBooking(String bookingId) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount++] = bookingId;
        }
    }

    public void displayGuestInfo() {
        System.out.println("Guest ID: " + guestId + " | Name: " + guestName + " | Phone: " + phoneNumber + " | Email: " + email);
    }
}

class Booking {
    String bookingId;
    Guest guest;
    Room room;
    String checkInDate;
    String checkOutDate;
    double totalAmount;

    static int totalBookings = 0;
    static double hotelRevenue = 0;
    static String hotelName = "Default Hotel";

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        totalBookings++;
        hotelRevenue += totalAmount;
    }

    public void displayBookingInfo() {
        System.out.println("Booking ID: " + bookingId + " | Guest: " + guest.guestName + " | Room: " + room.roomNumber +
                " | Check-in: " + checkInDate + " | Check-out: " + checkOutDate + " | Amount: " + totalAmount);
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }
}

class HotelSystem {
    Room[] rooms;
    Guest[] guests;
    Booking[] bookings;
    int bookingCount;

    public HotelSystem(Room[] rooms, Guest[] guests) {
        this.rooms = rooms;
        this.guests = guests;
        this.bookings = new Booking[50];
        this.bookingCount = 0;
    }

    public Room checkAvailability(String roomType) {
        for (Room r : rooms) {
            if (r != null && r.isAvailable && r.roomType.equalsIgnoreCase(roomType)) {
                return r;
            }
        }
        return null;
    }

    public Booking makeReservation(String bookingId, Guest guest, String roomType, String checkIn, String checkOut, int nights) {
        Room availableRoom = checkAvailability(roomType);
        if (availableRoom != null) {
            double totalAmount = availableRoom.pricePerNight * nights;
            Booking b = new Booking(bookingId, guest, availableRoom, checkIn, checkOut, totalAmount);
            bookings[bookingCount++] = b;
            guest.addBooking(bookingId);
            availableRoom.markBooked();
            System.out.println("Reservation successful!");
            b.displayBookingInfo();
            return b;
        } else {
            System.out.println("No rooms available for type: " + roomType);
            return null;
        }
    }

    public void cancelReservation(String bookingId) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null && bookings[i].bookingId.equals(bookingId)) {
                bookings[i].room.markAvailable();
                System.out.println("Reservation " + bookingId + " cancelled.");
                bookings[i] = null;
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public static double getOccupancyRate(Room[] rooms) {
        int total = rooms.length;
        int booked = 0;
        for (Room r : rooms) {
            if (!r.isAvailable) booked++;
        }
        return (double) booked / total * 100;
    }

    public static String getMostPopularRoomType(Room[] rooms) {
        String popularType = "";
        int max = 0;
        for (Room r : rooms) {
            if (r.timesBooked > max) {
                max = r.timesBooked;
                popularType = r.roomType;
            }
        }
        return popularType;
    }

    public void displayAllRooms() {
        System.out.println("\n--- Room List ---");
        for (Room r : rooms) {
            r.displayRoomInfo();
        }
    }

    public void displayAllBookings() {
        System.out.println("\n--- All Bookings ---");
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null) {
                bookings[i].displayBookingInfo();
            }
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
            new Room("R101", "Single", 2000, 1),
            new Room("R102", "Double", 3000, 2),
            new Room("R103", "Suite", 5000, 4)
        };

        Guest[] guests = {
            new Guest("G001", "Alice", "9876543210", "alice@mail.com"),
            new Guest("G002", "Bob", "9123456780", "bob@mail.com")
        };

        HotelSystem hotel = new HotelSystem(rooms, guests);

        int choice;
        do {
            System.out.println("\n=== Hotel Reservation Menu ===");
            System.out.println("1. View Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Bookings");
            System.out.println("5. View Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    hotel.displayAllRooms();
                    break;
                case 2:
                    System.out.print("Enter Booking ID: ");
                    String bid = sc.nextLine();
                    System.out.print("Enter Guest ID (G001/G002): ");
                    String gid = sc.nextLine();
                    Guest guest = null;
                    for (Guest g : guests) {
                        if (g.guestId.equals(gid)) guest = g;
                    }
                    if (guest == null) {
                        System.out.println("Guest not found!");
                        break;
                    }
                    System.out.print("Enter Room Type (Single/Double/Suite): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Check-In Date: ");
                    String cin = sc.nextLine();
                    System.out.print("Enter Check-Out Date: ");
                    String cout = sc.nextLine();
                    System.out.print("Enter Nights: ");
                    int nights = sc.nextInt();
                    sc.nextLine();
                    hotel.makeReservation(bid, guest, type, cin, cout, nights);
                    break;
                case 3:
                    System.out.print("Enter Booking ID to cancel: ");
                    String cancelId = sc.nextLine();
                    hotel.cancelReservation(cancelId);
                    break;
                case 4:
                    hotel.displayAllBookings();
                    break;
                case 5:
                    System.out.println("Occupancy Rate: " + HotelSystem.getOccupancyRate(rooms) + "%");
                    System.out.println("Total Revenue: " + Booking.getTotalRevenue());
                    System.out.println("Most Popular Room Type: " + HotelSystem.getMostPopularRoomType(rooms));
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}