class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void status() {
        System.out.println(deviceName + " status: Operational");
    }
}

class SmartTV extends SmartDevice {
    public SmartTV(String deviceName) {
        super(deviceName);
    }

    public void changeChannel(int channel) {
        System.out.println(deviceName + ": Channel changed to " + channel);
    }

    public void adjustVolume(int level) {
        System.out.println(deviceName + ": Volume set to " + level);
    }

    public void launchApp(String app) {
        System.out.println(deviceName + ": Launching app " + app);
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String deviceName) {
        super(deviceName);
    }

    public void setTemperature(double temp) {
        System.out.println(deviceName + ": Temperature set to " + temp + "°C");
    }

    public void setHumidity(double humidity) {
        System.out.println(deviceName + ": Humidity set to " + humidity + "%");
    }

    public void enableEnergySaving(boolean enable) {
        System.out.println(deviceName + ": Energy saving mode " + (enable ? "enabled" : "disabled"));
    }
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String deviceName) {
        super(deviceName);
    }

    public void activateAlarm() {
        System.out.println(deviceName + ": Alarm activated");
    }

    public void monitorCameras() {
        System.out.println(deviceName + ": Monitoring cameras");
    }

    public void accessControl(String user) {
        System.out.println(deviceName + ": Access granted to " + user);
    }
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String deviceName) {
        super(deviceName);
    }

    public void setCookingTime(int minutes) {
        System.out.println(deviceName + ": Cooking time set to " + minutes + " minutes");
    }

    public void setTemperature(double temp) {
        System.out.println(deviceName + ": Temperature set to " + temp + "°C");
    }

    public void selectRecipe(String recipe) {
        System.out.println(deviceName + ": Recipe selected: " + recipe);
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[4];
        devices[0] = new SmartTV("Living Room TV");
        devices[1] = new SmartThermostat("Hall Thermostat");
        devices[2] = new SmartSecurity("Front Door Security");
        devices[3] = new SmartKitchen("Kitchen Oven");

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartTV tv) {
                tv.changeChannel(5);
                tv.adjustVolume(20);
                tv.launchApp("Netflix");
            } else if (d instanceof SmartThermostat th) {
                th.setTemperature(22.5);
                th.setHumidity(45);
                th.enableEnergySaving(true);
            } else if (d instanceof SmartSecurity sec) {
                sec.activateAlarm();
                sec.monitorCameras();
                sec.accessControl("Alice");
            } else if (d instanceof SmartKitchen kit) {
                kit.setCookingTime(30);
                kit.setTemperature(180);
                kit.selectRecipe("Lasagna");
            }

            System.out.println();
        }
    }
}