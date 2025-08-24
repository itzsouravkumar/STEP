import java.util.*;

public class TextCalculator {

    static boolean isValid(String expr) {
        int balance = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            int ascii = (int) c;
            if (!(ascii == 32 || (ascii >= 48 && ascii <= 57) || "+-*/()".indexOf(c) != -1)) return false;
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    tokens.add(num.toString());
                    num.setLength(0);
                }
                if (c != ' ') tokens.add(String.valueOf(c));
            }
        }
        if (num.length() > 0) tokens.add(num.toString());
        return tokens;
    }

    static int applyOp(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }

    static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    static int evaluate(List<String> tokens) {
        Stack<Integer> values = new Stack<>();
        Stack<String> ops = new Stack<>();
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                values.push(Integer.parseInt(token));
            } else if (token.equals("(")) {
                ops.push(token);
            } else if (token.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    int b = values.pop(), a = values.pop();
                    values.push(applyOp(a, b, ops.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(token)) {
                    int b = values.pop(), a = values.pop();
                    values.push(applyOp(a, b, ops.pop()));
                }
                ops.push(token);
            }
        }
        while (!ops.isEmpty()) {
            int b = values.pop(), a = values.pop();
            values.push(applyOp(a, b, ops.pop()));
        }
        return values.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of expressions: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter expression: ");
            String expr = sc.nextLine();
            if (!isValid(expr)) {
                System.out.println("Invalid expression");
                continue;
            }
            List<String> tokens = tokenize(expr);
            int result = evaluate(tokens);
            System.out.println("Expression: " + expr);
            System.out.println("Result: " + result);
        }
        sc.close();
    }
}