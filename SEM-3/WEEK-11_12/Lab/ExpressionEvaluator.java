import java.util.*;
import java.util.regex.*;

public class ExpressionEvaluator {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/", "%", "^");
    private static final Map<String, Integer> PRECEDENCE = Map.of(
        "+", 1, "-", 1,
        "*", 2, "/", 2, "%", 2,
        "^", 3
    );

    public static String evaluate(String expr, Map<String, Integer> env) {
        try {
            List<String> tokens = tokenize(expr);
            List<String> postfix = toPostfix(tokens);
            int result = evalPostfix(postfix, env);
            return String.valueOf(result);
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+|[a-zA-Z_]+|[()+\\-*/%^,]").matcher(expr.replaceAll("\\s+", ""));
        while (m.find()) tokens.add(m.group());
        return tokens;
    }

    private static List<String> toPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> ops = new ArrayDeque<>();

        String prev = "";
        for (String token : tokens) {
            if (isNumber(token) || isVariable(token)) {
                output.add(token);
            } else if (isFunction(token)) {
                ops.push(token);
            } else if (token.equals(",")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    output.add(ops.pop());
                }
                if (ops.isEmpty()) throw new RuntimeException("Misplaced comma");
            } else if (OPERATORS.contains(token)) {
                if (token.equals("-") && (prev.isEmpty() || OPERATORS.contains(prev) || prev.equals("(") || prev.equals(","))) {
                    ops.push("u-");
                } else {
                    while (!ops.isEmpty() && isHigherPrec(ops.peek(), token)) {
                        output.add(ops.pop());
                    }
                    ops.push(token);
                }
            } else if (token.equals("(")) {
                ops.push(token);
            } else if (token.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    output.add(ops.pop());
                }
                if (ops.isEmpty()) throw new RuntimeException("Mismatched parentheses");
                ops.pop();
                if (!ops.isEmpty() && isFunction(ops.peek())) output.add(ops.pop());
            } else throw new RuntimeException("Invalid token: " + token);
            prev = token;
        }

        while (!ops.isEmpty()) {
            String op = ops.pop();
            if (op.equals("(") || op.equals(")")) throw new RuntimeException("Mismatched parentheses");
            output.add(op);
        }

        return output;
    }

    private static int evalPostfix(List<String> postfix, Map<String, Integer> env) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isVariable(token)) {
                if (!env.containsKey(token)) throw new RuntimeException("Missing variable: " + token);
                stack.push(env.get(token));
            } else if (token.equals("u-")) {
                if (stack.isEmpty()) throw new RuntimeException("Unary minus error");
                stack.push(-stack.pop());
            } else if (OPERATORS.contains(token)) {
                if (stack.size() < 2) throw new RuntimeException("Operator stack underflow");
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": if (b == 0) throw new RuntimeException("Divide by zero");
                              stack.push(a / b); break;
                    case "%": if (b == 0) throw new RuntimeException("Divide by zero");
                              stack.push(a % b); break;
                    case "^": stack.push((int)Math.pow(a, b)); break;
                }
            } else if (isFunction(token)) {
                switch (token) {
                    case "abs":
                        if (stack.isEmpty()) throw new RuntimeException("Missing arg for abs");
                        stack.push(Math.abs(stack.pop()));
                        break;
                    case "min":
                    case "max":
                        if (stack.size() < 2) throw new RuntimeException("Missing args for " + token);
                        int y = stack.pop(), x = stack.pop();
                        stack.push(token.equals("min") ? Math.min(x, y) : Math.max(x, y));
                        break;
                }
            } else throw new RuntimeException("Invalid token in eval: " + token);
        }

        if (stack.size() != 1) throw new RuntimeException("Invalid postfix");
        return stack.pop();
    }

    private static boolean isNumber(String s) {
        return s.matches("-?\\d+");
    }

    private static boolean isVariable(String s) {
        return s.matches("[a-zA-Z_]+") && !isFunction(s);
    }

    private static boolean isFunction(String s) {
        return s.equals("min") || s.equals("max") || s.equals("abs");
    }

    private static boolean isHigherPrec(String op1, String op2) {
        if (op1.equals("(") || op1.equals(")")) return false;
        int p1 = PRECEDENCE.getOrDefault(op1, 4);
        int p2 = PRECEDENCE.getOrDefault(op2, 4);
        if (op1.equals("^") && op2.equals("^")) return false;
        return p1 >= p2;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("3 + 4 * 2 / (1 - 5) ^ 2^3", Map.of()));
        System.out.println(evaluate("min(10, max(2, 3*4))", Map.of()));
        System.out.println(evaluate("-(x) + abs(y)", Map.of("x", -2, "y", -7)));
        System.out.println(evaluate("a + b", Map.of("a", 1)));
    }
}