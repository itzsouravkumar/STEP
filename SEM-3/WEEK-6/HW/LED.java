public class LED extends Light {
    protected String color;

    LED() {
        this("LED", 10, "White");
        System.out.println("LED default constructor");
    }

    LED(String type, int wattage) {
        super(type, wattage);
        System.out.println("LED two-parameter constructor");
    }

    LED(String type, int wattage, String color) {
        super(type, wattage);
        this.color = color;
        System.out.println("LED three-parameter constructor");
    }

    public static void main(String[] args) {
        System.out.println("Creating LED with default constructor:");
        LED l1 = new LED();

        System.out.println("\nCreating LED with two parameters:");
        LED l2 = new LED("LED", 15);

        System.out.println("\nCreating LED with three parameters:");
        LED l3 = new LED("LED", 20, "Blue");

        System.out.println("\nValues: " + l3.type + ", " + l3.wattage + "W, " + l3.color);
    }
}
class Light {
    protected String type;
    protected int wattage;

    Light() {
        this("Generic", 0);
        System.out.println("Light default constructor");
    }

    Light(String type) {
        this(type, 60);
        System.out.println("Light single-parameter constructor");
    }

    Light(String type, int wattage) {
        this.type = type;
        this.wattage = wattage;
        System.out.println("Light two-parameter constructor");
    }
}

