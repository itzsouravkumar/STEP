class RedColor extends PrimaryColor {
    protected String shade;

    RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor");
    }

    public static void main(String[] args) {
        RedColor r = new RedColor("Red", 90, "Dark Red");
        System.out.println("Name: " + r.name);
        System.out.println("Intensity: " + r.intensity);
        System.out.println("Shade: " + r.shade);
    }
}

class Color {
    protected String name;

    Color(String name) {
        this.name = name;
        System.out.println("Color constructor");
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor");
    }
}

