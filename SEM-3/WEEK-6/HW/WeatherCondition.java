public class WeatherCondition {
    public static void main(String[] args) {
        Weather[] weatherArray = {
            new Weather(),
            new Storm(),
            new Thunderstorm(),
            new Sunshine("Sunny", 35)
        };

        for (Weather w : weatherArray) {
            w.showCondition();
            System.out.println();
        }
    }
}

class Weather {
    protected String condition;

    Weather() {
        System.out.println("Weather default constructor");
        this.condition = "Unknown";
    }

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather parameterized constructor: " + condition);
    }

    void showCondition() {
        System.out.println("Weather condition: " + condition);
    }
}

class Storm extends Weather {
    protected int windSpeed;

    Storm() {
        super("Stormy");
        System.out.println("Storm default constructor");
        this.windSpeed = 50;
    }

    Storm(String condition, int windSpeed) {
        super(condition);
        this.windSpeed = windSpeed;
        System.out.println("Storm parameterized constructor: " + windSpeed + " km/h");
    }

    @Override
    void showCondition() {
        System.out.println("Storm condition: " + condition + ", wind speed: " + windSpeed + " km/h");
    }
}

class Thunderstorm extends Storm {
    protected int lightningCount;

    Thunderstorm() {
        super("Thunderstorm", 80);
        this.lightningCount = 10;
        System.out.println("Thunderstorm default constructor");
    }

    Thunderstorm(String condition, int windSpeed, int lightningCount) {
        super(condition, windSpeed);
        this.lightningCount = lightningCount;
        System.out.println("Thunderstorm parameterized constructor: " + lightningCount + " lightning strikes");
    }

    @Override
    void showCondition() {
        System.out.println("Thunderstorm with " + lightningCount + " lightning strikes, wind speed: " + windSpeed + " km/h");
    }
}

class Sunshine extends Weather {
    protected int temperature;

    Sunshine() {
        super("Sunny");
        this.temperature = 30;
        System.out.println("Sunshine default constructor");
    }

    Sunshine(String condition, int temperature) {
        super(condition);
        this.temperature = temperature;
        System.out.println("Sunshine parameterized constructor: " + temperature + "°C");
    }

    @Override
    void showCondition() {
        System.out.println("Sunshine condition: " + condition + ", temperature: " + temperature + "°C");
    }
}

