public class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    public void showDetails() {
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}