public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // TODO: No-argument constructor using this() chaining
    public AudioMixer() {
        // Call three-parameter constructor with defaults
        this("StandardMix-8", 8, false);
    }

    // TODO: Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        // Call three-parameter constructor with bluetooth disabled
        this(mixerModel, numberOfChannels, false);
    }

    // TODO: Three-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity) {
        // Call main constructor with default max volume (120.0)
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    // TODO: Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        // Initialize all fields
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;

        // Initialize connectedDevices array based on numberOfChannels
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;

        // Print constructor execution message
        System.out.println("Constructor executed for model: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);

        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        // TODO: Create mixer using no-argument constructor
        AudioMixer mixer1 = new AudioMixer();

        // TODO: Create mixer using two-parameter constructor
        AudioMixer mixer2 = new AudioMixer("ProMix-12", 12);

        // TODO: Create mixer using three-parameter constructor
        AudioMixer mixer3 = new AudioMixer("DJMix-6", 6, true);

        // TODO: Create mixer using full constructor
        AudioMixer mixer4 = new AudioMixer("UltraMix-16", 16, true, 150.0);

        // TODO: Connect different devices to each mixer
        mixer1.connectDevice("Microphone");
        mixer1.connectDevice("Keyboard");

        mixer2.connectDevice("Guitar");
        mixer2.connectDevice("Drums");
        mixer2.connectDevice("Laptop");

        mixer3.connectDevice("Turntable");
        mixer3.connectDevice("Headphones");

        mixer4.connectDevice("Bass");
        mixer4.connectDevice("Synthesizer");
        mixer4.connectDevice("Vocals");
        mixer4.connectDevice("Sampler");

        // TODO: Display status of all mixers
        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        // TODO: Comment on constructor chaining execution order
        System.out.println("\n--- NOTE ON CONSTRUCTOR CHAINING ---");
        System.out.println("No-argument constructor -> calls two/three-parameter constructor -> calls main constructor.");
        System.out.println("This ensures all initialization logic is centralized in the main constructor.");
    }
}
