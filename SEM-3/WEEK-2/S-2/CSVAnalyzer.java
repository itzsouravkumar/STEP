import java.util.*;

public class CSVAnalyzer {

    static String[][] parseCSV(String input) {
        List<String[]> rows = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        List<String> currentRow = new ArrayList<>();
        boolean inQuotes = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"') inQuotes = !inQuotes;
            else if (c == ',' && !inQuotes) {
                currentRow.add(field.toString());
                field.setLength(0);
            } else if (c == '\n') {
                currentRow.add(field.toString());
                rows.add(currentRow.toArray(new String[0]));
                currentRow.clear();
                field.setLength(0);
            } else {
                field.append(c);
            }
        }
        if (field.length() > 0) currentRow.add(field.toString());
        if (!currentRow.isEmpty()) rows.add(currentRow.toArray(new String[0]));

        return rows.toArray(new String[0][]);
    }

    static String cleanField(String field) {
        return field.trim();
    }

    static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            if (!(ascii >= 48 && ascii <= 57) && ascii != 46) return false;
        }
        return true;
    }

    static void analyzeData(String[][] data) {
        int rows = data.length, cols = data[0].length;
        double[] sum = new double[cols];
        double[] min = new double[cols];
        double[] max = new double[cols];
        int[] count = new int[cols];
        Arrays.fill(min, Double.MAX_VALUE);
        Arrays.fill(max, Double.MIN_VALUE);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String field = cleanField(data[i][j]);
                if (isNumeric(field)) {
                    double val = Double.parseDouble(field);
                    sum[j] += val;
                    count[j]++;
                    if (val < min[j]) min[j] = val;
                    if (val > max[j]) max[j] = val;
                }
            }
        }

        System.out.println("\nColumn Statistics:");
        for (int j = 0; j < cols; j++) {
            if (count[j] > 0) {
                System.out.printf("%s -> Min: %.2f, Max: %.2f, Avg: %.2f\n",
                        data[0][j], min[j], max[j], sum[j] / count[j]);
            }
        }
    }

    static void displayTable(String[][] data) {
        int cols = data[0].length;
        int[] widths = new int[cols];

        for (int j = 0; j < cols; j++) {
            int maxLen = 0;
            for (int i = 0; i < data.length; i++) {
                maxLen = Math.max(maxLen, data[i][j].length());
            }
            widths[j] = maxLen + 2;
        }

        System.out.println("\nFormatted Table:");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%-" + widths[j] + "s", data[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV data (end with an empty line): ");
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }

        String[][] data = parseCSV(input.toString());
        displayTable(data);
        analyzeData(data);
        sc.close();
    }
}
