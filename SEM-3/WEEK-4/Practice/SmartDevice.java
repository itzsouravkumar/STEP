public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // TODO: Constructor with parameter names matching field names
    public SmartDevice(String deviceName, String location,
                       boolean isOnline, double powerConsumption) {
        // Use this keyword to distinguish between parameters and fields
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;

        // Initialize connectedDevices array (size 5)
        this.connectedDevices = new String[5];
        // Set connectionCount to 0
        this.connectionCount = 0;
    }

    // TODO: Method using this for parameter disambiguation
    public void updateLocation(String location) {
        this.location = location; // disambiguation
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption; // disambiguation
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // TODO: Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this; // enable chaining
    }

    public SmartDevice connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        } else {
            System.out.println("Connection limit reached for " + this.deviceName);
        }
        return this; // enable chaining
    }

    public SmartDevice rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this; // enable chaining
    }

    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    // TODO: Method that calls other methods using this
    public void performInitialSetup() {
        this.setOnline(true); // calling other method using this
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        // TODO: Create devices with parameter names matching field names
        SmartDevice device1 = new SmartDevice("Smart Light", "Living Room", false, 15.5);
        SmartDevice device2 = new SmartDevice("Thermostat", "Bedroom", true, 10.0);

        // TODO: Test method chaining using returned this
        device1.setOnline(true)
                .connectToDevice("Alexa")
                .rename("Living Room Light")
                .connectToDevice("Google Home");

        // TODO: Demonstrate this keyword in various contexts
        device2.updateLocation("Hallway");
        device2.updatePowerConsumption(12.0);
        device2.performInitialSetup();

        // Display info for both devices
        device1.displayDeviceInfo();
        device2.displayDeviceInfo();

        // Example of method chaining (already shown above)
        // device.setOnline(true).connectToDevice("Alexa").rename("Kitchen Hub");
    }
}