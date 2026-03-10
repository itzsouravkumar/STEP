import java.util.HashMap;
import java.util.Map;

class ParkingSpot {
    String licensePlate;
    long entryTime;
    boolean isDeleted;

    public ParkingSpot(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = System.currentTimeMillis();
        this.isDeleted = false;
    }
}

public class ParkingLotManager {
    private final int CAPACITY = 500;
    private final ParkingSpot[] spots;
    private int size;
    private int totalProbes;
    private int totalParkings;

    public ParkingLotManager() {
        this.spots = new ParkingSpot[CAPACITY];
        this.size = 0;
        this.totalProbes = 0;
        this.totalParkings = 0;
    }

    private int hash(String licensePlate) {
        int hash = 0;
        for (char c : licensePlate.toCharArray()) {
            hash = (hash * 31 + c) % CAPACITY;
        }
        return Math.abs(hash);
    }

    public String parkVehicle(String licensePlate) {
        if (size == CAPACITY) {
            return "Parking Lot Full";
        }

        int hashValue = hash(licensePlate);
        int probeCount = 0;
        int index = hashValue;

        while (spots[index] != null && !spots[index].isDeleted) {
            probeCount++;
            index = (index + 1) % CAPACITY;
        }

        spots[index] = new ParkingSpot(licensePlate);
        size++;
        totalProbes += probeCount;
        totalParkings++;

        String msg = "Assigned spot #" + index + " (" + probeCount + " probes)";
        if (probeCount > 0) {
            return "Assigned spot #" + hashValue + "... occupied... Spot #" + index + " (" + probeCount + " probes)";
        }
        return msg;
    }

    public String exitVehicle(String licensePlate) {
        int hashValue = hash(licensePlate);
        int index = hashValue;
        int probeCount = 0;

        while (spots[index] != null) {
            if (!spots[index].isDeleted && spots[index].licensePlate.equals(licensePlate)) {
                spots[index].isDeleted = true;
                size--;
                
                long durationMs = System.currentTimeMillis() - spots[index].entryTime;
                // For demonstration, convert ms to hours (simulated)
                long hours = (durationMs / 1000) + 1; // 1 second = 1 hour for demo
                double fee = hours * 5.0;

                return "Spot #" + index + " freed, Duration: " + hours + "h, Fee: $" + String.format("%.2f", fee);
            }
            index = (index + 1) % CAPACITY;
            probeCount++;
            if (probeCount >= CAPACITY) break; // Traversed entire array
        }

        return "Vehicle not found";
    }

    public String getStatistics() {
        double occupancy = (double) size / CAPACITY * 100;
        double avgProbes = totalParkings == 0 ? 0 : (double) totalProbes / totalParkings;
        return String.format("Occupancy: %.0f%%, Avg Probes: %.1f", occupancy, avgProbes);
    }

    public static void main(String[] args) {
        ParkingLotManager manager = new ParkingLotManager();
        System.out.println("parkVehicle(\"ABC-1234\") -> " + manager.parkVehicle("ABC-1234"));
        System.out.println("parkVehicle(\"ABC-1235\") -> " + manager.parkVehicle("ABC-1235"));
        System.out.println("parkVehicle(\"XYZ-9999\") -> " + manager.parkVehicle("XYZ-9999"));
        
        try {
            Thread.sleep(2000); // Wait 2 seconds (simulating 2 hours)
        } catch (InterruptedException e) {}

        System.out.println("exitVehicle(\"ABC-1234\") -> " + manager.exitVehicle("ABC-1234"));
        System.out.println("getStatistics() -> " + manager.getStatistics());
    }
}
