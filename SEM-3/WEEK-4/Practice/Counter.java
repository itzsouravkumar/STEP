public class Counter {
    static int count = 0;

    Counter() {
        // TODO: Increment count
        count++;
    }

    // TODO: Static method getCount()
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // TODO: Create several Counter objects
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        // TODO: Display number of objects created
        System.out.println("Number of Counter objects created: " + Counter.getCount());
    }
}
