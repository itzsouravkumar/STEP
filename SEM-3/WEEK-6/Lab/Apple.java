class Apple extends Fruit {
    protected String variety;

    public static void main(String[] args) {
        Apple a = new Apple();
        a.color = "Red";
        a.taste = "Sweet";
        a.variety = "Fuji";
        System.out.println("Color: " + a.color);
        System.out.println("Taste: " + a.taste);
        System.out.println("Variety: " + a.variety);
    }
}
class Fruit {
    protected String color;
    protected String taste;
}
