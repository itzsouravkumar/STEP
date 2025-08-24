import java.util.Scanner;

public class SimpleSpellChecker {
  public static String[] splitSentence(String sentence) {
    int n = sentence.length();
    String[] temp = new String[n];
    int count = 0;
    int start = -1;
    for (int i = 0; i < n; i++) {
      char c = sentence.charAt(i);
      if (Character.isLetter(c)) {
        if (start == -1)
          start = i; // word begins
      } else {
        if (start != -1) {
          temp[count++] = sentence.substring(start, i);
          start = -1;
        }
      }
    }
    if (start != -1) {
      temp[count++] = sentence.substring(start);
    }

    String[] words = new String[count];
    for (int i = 0; i < count; i++) {
      words[i] = temp[i];
    }
    return words;
  }

  public static int stringDistance(String a, String b) {
    if (a.length() == b.length()) {
      int diff = 0;
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i))
          diff++;
      }
      return diff;
    } else {
      return Math.abs(a.length() - b.length());
    }
  }

  public static String findClosest(String word, String[] dictionary) {
    int minDist = Integer.MAX_VALUE;
    String bestMatch = null;
    for (String dictWord : dictionary) {
      int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
      if (dist < minDist) {
        minDist = dist;
        bestMatch = dictWord;
      }
    }

    return (minDist <= 2) ? bestMatch : null;
  }

  public static void displayResults(String[] words, String[] dictionary) {
    System.out.printf("%-15s %-15s %-10s %-15s\n", "Original", "Suggestion", "Distance", "Status");
    System.out.println("---------------------------------------------------------------");
    for (String word : words) {
      String suggestion = findClosest(word, dictionary);
      if (suggestion == null || suggestion.equalsIgnoreCase(word)) {
        System.out.printf("%-15s %-15s %-10d %-15s\n",
            word, "-", 0, "Correct");
      } else {
        int dist = stringDistance(word, suggestion);
        System.out.printf("%-15s %-15s %-10d %-15s\n",
            word, suggestion, dist, "Misspelled");
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] dictionary = { "hello", "world", "java", "programming", "spell", "checker", "example" };
    System.out.print("Enter a sentence:");
    String sentence = sc.nextLine();
    String[] words = splitSentence(sentence);
    displayResults(words, dictionary);
    sc.close();
  }
}
