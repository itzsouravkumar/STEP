public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.displayInfo();

        System.out.println();

        Shape rectangle = new Rectangle(4, 6);
        rectangle.displayInfo();
    }
}