public class SmartCampus {
    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[3];
        devices[0] = new SmartClassroom("Classroom A");
        devices[1] = new SmartLab("Lab 101");
        devices[2] = new SmartLibrary("Library Central");

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartClassroom) {
                SmartClassroom sc = (SmartClassroom) d;
                sc.controlLighting();
                sc.controlAC();
                sc.controlProjector();
            } else if (d instanceof SmartLab) {
                SmartLab sl = (SmartLab) d;
                sl.manageEquipment();
                sl.checkSafety();
            } else if (d instanceof SmartLibrary) {
                SmartLibrary slib = (SmartLibrary) d;
                slib.trackOccupancy();
                slib.checkBookAvailability();
            }

            System.out.println();
        }
    }
}

class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void status() {
        System.out.println(deviceName + " status: Operational");
    }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String deviceName) {
        super(deviceName);
    }

    public void controlLighting() {
        System.out.println(deviceName + ": Lighting adjusted.");
    }

    public void controlAC() {
        System.out.println(deviceName + ": AC temperature set.");
    }

    public void controlProjector() {
        System.out.println(deviceName + ": Projector switched on.");
    }
}

class SmartLab extends SmartDevice {
    public SmartLab(String deviceName) {
        super(deviceName);
    }

    public void manageEquipment() {
        System.out.println(deviceName + ": Lab equipment managed.");
    }

    public void checkSafety() {
        System.out.println(deviceName + ": Safety systems checked.");
    }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String deviceName) {
        super(deviceName);
    }

    public void trackOccupancy() {
        System.out.println(deviceName + ": Occupancy tracked.");
    }

    public void checkBookAvailability() {
        System.out.println(deviceName + ": Book availability checked.");
    }
}