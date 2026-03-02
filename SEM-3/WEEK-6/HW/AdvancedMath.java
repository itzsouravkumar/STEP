public class AdvancedMath extends BasicMath {
    int calculate(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    double calculate(double a, double b, double c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();

        System.out.println("2 ints: " + am.calculate(5, 10));
        System.out.println("3 ints: " + am.calculate(1, 2, 3));
        System.out.println("2 doubles: " + am.calculate(2.5, 3.5));
        System.out.println("4 ints: " + am.calculate(1, 2, 3, 4));
        System.out.println("3 doubles: " + am.calculate(1.1, 2.2, 3.3));
    }
}

class BasicMath {
    int calculate(int a, int b) {
        return a + b;
    }

    int calculate(int a, int b, int c) {
        return a + b + c;
    }

    double calculate(double a, double b) {
        return a + b;
    }
}
