import java.util.*;
public class stringPerformance {

    public static long concatString(int n) {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) s += "x";
        long end = System.currentTimeMillis();
        System.out.println("String       | Time: " + (end - start) + " ms | Length: " + s.length());
        return end - start;
    }

    public static long concatStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) sb.append("x");
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder| Time: " + (end - start) + " ms | Length: " + sb.length());
        return end - start;
    }

    public static long concatStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) sb.append("x");
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer | Time: " + (end - start) + " ms | Length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        concatString(n);
        concatStringBuilder(n);
        concatStringBuffer(n);

        sc.close();
    }
}

