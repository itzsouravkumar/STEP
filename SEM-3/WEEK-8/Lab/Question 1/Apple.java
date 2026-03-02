public class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple Variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Rich in fiber, vitamins, and antioxidants.");
    }
}