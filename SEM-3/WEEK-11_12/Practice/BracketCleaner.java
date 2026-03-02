import java.util.*;

public class BracketCleaner {
    public static void main(String[] args) {
        String[] inputs = {
            "The sum is (a[b*c] + d)",
            "<[*(])>",
            "hello*)("
        };

        for (String in : inputs) {
            System.out.println("Input:  " + in);
            System.out.println("Output: " + cleanMarkdownBrackets(in));
            System.out.println();
        }
    }

    private static boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }
    private static boolean isClose(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>';
    }
    private static char matchingOpen(char close) {
        return switch (close) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            default -> '?';
        };
    }

    public static String cleanMarkdownBrackets(String s) {
        int n = s.length();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep, false);

        Deque<int[]> openStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!isOpen(c) && !isClose(c) && c != '*') {
                keep[i] = true;
            }
        }

        Set<Character> brackets = Set.of('(', ')', '[', ']', '{', '}', '<', '>');
        java.util.function.IntPredicate isWildcardStar = (idx) -> {
            char left = idx - 1 >= 0 ? s.charAt(idx - 1) : 0;
            char right = idx + 1 < n ? s.charAt(idx + 1) : 0;
            return brackets.contains(left) || brackets.contains(right);
        };

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isOpen(c)) {
                openStack.push(new int[]{c, i});
            } else if (c == '*') {
                if (isWildcardStar.test(i)) {
                    starStack.push(i);
                } else {
                    keep[i] = true;
                }
            } else if (isClose(c)) {
                char wantOpen = matchingOpen(c);
                boolean found = false;
                ArrayDeque<int[]> temp = new ArrayDeque<>();
                while (!openStack.isEmpty()) {
                    int[] top = openStack.pop();
                    if ((char) top[0] == wantOpen) {
                        keep[top[1]] = true;
                        keep[i] = true;
                        found = true;
                        break;
                    } else {
                        temp.push(top);
                    }
                }
                if (!found) {
                    while (!temp.isEmpty()) {
                        openStack.push(temp.pop());
                    }
                } else {
                    temp.clear();
                }
            }
        }

        while (!starStack.isEmpty() && !openStack.isEmpty()) {
            int starIdx = starStack.peek();
            int[] topOpen = openStack.peek();
            int openIdx = topOpen[1];
            if (openIdx < starIdx) {
                openStack.pop();
                starStack.pop();
                keep[openIdx] = true;
                keep[starIdx] = false;
            } else {
                starStack.pop();
                keep[starIdx] = false;
            }
        }
        while (!starStack.isEmpty()) {
            int idx = starStack.pop();
            keep[idx] = false;
        }

        while (!openStack.isEmpty()) {
            int[] o = openStack.pop();
            keep[o[1]] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (keep[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }    
}