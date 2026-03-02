public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.draw();
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.showDetails();
    }
}