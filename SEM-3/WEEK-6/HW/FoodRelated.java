public class FoodRelated {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();

        System.out.println("Preparing Pizza:");
        f1.prepare();

        System.out.println("\nPreparing Soup:");
        f2.prepare();
    }
}

abstract class Food {
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and dough ingredients for pizza");
    }

    @Override
    protected void cook() {
        System.out.println("Baking pizza in oven");
    }

    @Override
    protected void serve() {
        System.out.println("Serving hot pizza with toppings");
    }
}

class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables for soup");
    }

    @Override
    protected void cook() {
        System.out.println("Boiling soup ingredients");
    }

    @Override
    protected void serve() {
        System.out.println("Serving soup in a bowl");
    }
}
