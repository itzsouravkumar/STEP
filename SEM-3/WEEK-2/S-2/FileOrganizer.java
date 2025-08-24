import java.util.*;

public class FileOrganizer {

    static String getExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1) return "";
        return filename.substring(dot + 1).toLowerCase();
    }

    static String getName(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1) return filename;
        return filename.substring(0, dot);
    }

    static String categorize(String ext) {
        if (ext.equals("txt") || ext.equals("doc") || ext.equals("docx")) return "Document";
        if (ext.equals("jpg") || ext.equals("png") || ext.equals("jpeg")) return "Image";
        if (ext.equals("mp3") || ext.equals("wav")) return "Audio";
        if (ext.equals("mp4") || ext.equals("mkv")) return "Video";
        if (ext.equals("pdf")) return "PDF";
        return "Unknown";
    }

    static String generateNewName(String category, String name, int index) {
        String date = java.time.LocalDate.now().toString();
        return category + "" + name + "" + date + "_" + index;
    }

    static void displayReport(String[] files, String[] categories, String[] newNames) {
        System.out.printf("%-20s %-15s %-25s\n", "Original", "Category", "New Name");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%-20s %-15s %-25s\n", files[i], categories[i], newNames[i]);
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String c : categories) counts.put(c, counts.getOrDefault(c, 0) + 1);

        System.out.println("\nCategory Counts:");
        for (String c : counts.keySet()) {
            System.out.println(c + " : " + counts.get(c));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] files = new String[n];
        String[] categories = new String[n];
        String[] newNames = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name " + (i + 1) + ": ");
            files[i] = sc.nextLine();
            String ext = getExtension(files[i]);
            String name = getName(files[i]);
            categories[i] = categorize(ext);
            newNames[i] = generateNewName(categories[i], name, i + 1);
        }

        displayReport(files, categories, newNames);
        sc.close();
    }
}