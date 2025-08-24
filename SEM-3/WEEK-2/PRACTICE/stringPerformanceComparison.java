public class stringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // String
        long start = System.nanoTime();
        concatenateWithString(10000);
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) + " ns");

        // StringBuilder
        start = System.nanoTime();
        concatenateWithStringBuilder(10000);
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) + " ns");

        // StringBuffer
        start = System.nanoTime();
        concatenateWithStringBuffer(10000);
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) + " ns");

        demonstrateStringBuilderMethods();
        compareStringComparisonMethods();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!!!");
        sb.insert(6, "Java ");
        sb.delete(0, 6);
        sb.deleteCharAt(0);
        sb.reverse();
        sb.replace(0, 4, "Test");
        sb.setCharAt(0, 'X');
        System.out.println("StringBuilder Demo: " + sb);
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensure: " + sb.capacity());
        sb.trimToSize();
        System.out.println("Capacity after trim: " + sb.capacity());
    }

    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== operator: " + (str1 == str2));
        System.out.println("== with new: " + (str1 == str3));
        System.out.println("equals: " + str1.equals(str3));
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo: " + str1.compareTo("World"));
        System.out.println("compareToIgnoreCase: " + str1.compareToIgnoreCase("hello"));
    }
}
