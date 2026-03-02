import java.util.*;

public class ExpressionEvaluator {
    
    private static final Map<String, Integer> PRECEDENCE = new HashMap<>();
    private static final Set<String> RIGHT_ASSOC = new HashSet<>();
    private static final Set<String> FUNCTIONS = new HashSet<>();
    
    static {
        PRECEDENCE.put("||", 1);
        PRECEDENCE.put("&&", 2);
        PRECEDENCE.put("==", 3);
        PRECEDENCE.put("!=", 3);
        PRECEDENCE.put("<", 4);
        PRECEDENCE.put("<=", 4);
        PRECEDENCE.put(">", 4);
        PRECEDENCE.put(">=", 4);
        PRECEDENCE.put("+", 5);
        PRECEDENCE.put("-", 5);
        PRECEDENCE.put("*", 6);
        PRECEDENCE.put("/", 6);
        PRECEDENCE.put("%", 6);
        PRECEDENCE.put("^", 7);
        PRECEDENCE.put("unary+", 8);
        PRECEDENCE.put("unary-", 8);
        PRECEDENCE.put("!", 8);
        PRECEDENCE.put("?:", 0); // Ternary has lowest precedence
        
        RIGHT_ASSOC.add("^");
        RIGHT_ASSOC.add("unary+");
        RIGHT_ASSOC.add("unary-");
        RIGHT_ASSOC.add("!");
        RIGHT_ASSOC.add("?:");
        
        FUNCTIONS.add("min");
        FUNCTIONS.add("max");
        FUNCTIONS.add("abs");
        FUNCTIONS.add("sgn");
    }
    
    public static ExprResult evaluate(String expr, Map<String, String> env) {
        try {
            List<Token> tokens = tokenize(expr);
            List<Token> rpnTokens = toRPN(tokens);
            Node result = evaluateRPN(rpnTokens, env);
            
            String rpnStr = buildRPNString(rpnTokens);
            return new ExprResult(result.value, rpnStr, result.canonical);
        } catch (Exception e) {
            return null; // Return null on error
        }
    }
    
    private static List<Token> tokenize(String expr) throws Exception {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        
        while (i < expr.length()) {
            char c = expr.charAt(i);
            
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            
            if (Character.isDigit(c) || (c == '-' && i + 1 < expr.length() && Character.isDigit(expr.charAt(i + 1)) && 
                (tokens.isEmpty() || tokens.get(tokens.size() - 1).type == Token.Type.OPERATOR || 
                 tokens.get(tokens.size() - 1).type == Token.Type.LPAREN || 
                 tokens.get(tokens.size() - 1).type == Token.Type.COMMA ||
                 tokens.get(tokens.size() - 1).type == Token.Type.TERNARY_Q ||
                 tokens.get(tokens.size() - 1).type == Token.Type.TERNARY_COLON))) {
                StringBuilder num = new StringBuilder();
                if (c == '-') {
                    num.append(c);
                    i++;
                }
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num.append(expr.charAt(i));
                    i++;
                }
                tokens.add(new Token(Token.Type.NUMBER, num.toString()));
                continue;
            }
            
            if (Character.isLetter(c) || c == '_') {
                StringBuilder id = new StringBuilder();
                while (i < expr.length() && (Character.isLetterOrDigit(expr.charAt(i)) || expr.charAt(i) == '_')) {
                    id.append(expr.charAt(i));
                    i++;
                }
                String identifier = id.toString();
                if (identifier.equals("true") || identifier.equals("false")) {
                    tokens.add(new Token(Token.Type.BOOLEAN, identifier));
                } else if (FUNCTIONS.contains(identifier)) {
                    tokens.add(new Token(Token.Type.FUNCTION, identifier));
                } else {
                    tokens.add(new Token(Token.Type.VARIABLE, identifier));
                }
                continue;
            }
            
            if (c == '(') {
                tokens.add(new Token(Token.Type.LPAREN, "("));
                i++;
                continue;
            }
            
            if (c == ')') {
                tokens.add(new Token(Token.Type.RPAREN, ")"));
                i++;
                continue;
            }
            
            if (c == ',') {
                tokens.add(new Token(Token.Type.COMMA, ","));
                i++;
                continue;
            }
            
            if (c == '?') {
                tokens.add(new Token(Token.Type.TERNARY_Q, "?"));
                i++;
                continue;
            }
            
            if (c == ':') {
                tokens.add(new Token(Token.Type.TERNARY_COLON, ":"));
                i++;
                continue;
            }
            
            // Multi-character operators
            if (i + 1 < expr.length()) {
                String twoChar = expr.substring(i, i + 2);
                if (twoChar.equals("||") || twoChar.equals("&&") || twoChar.equals("==") || 
                    twoChar.equals("!=") || twoChar.equals("<=") || twoChar.equals(">=")) {
                    tokens.add(new Token(Token.Type.OPERATOR, twoChar));
                    i += 2;
                    continue;
                }
            }
            
            // Single-character operators
            if ("+-*/%^<>!".indexOf(c) >= 0) {
                tokens.add(new Token(Token.Type.OPERATOR, String.valueOf(c)));
                i++;
                continue;
            }
            
            throw new Exception("Invalid character: " + c);
        }
        
        return tokens;
    }
    
    private static List<Token> toRPN(List<Token> tokens) throws Exception {
        List<Token> output = new ArrayList<>();
        Stack<Token> opStack = new Stack<>();
        
        for (int i = 0; i < tokens.size(); i++) {
            Token tok = tokens.get(i);
            
            if (tok.type == Token.Type.NUMBER || tok.type == Token.Type.BOOLEAN || tok.type == Token.Type.VARIABLE) {
                output.add(tok);
            } else if (tok.type == Token.Type.FUNCTION) {
                opStack.push(tok);
            } else if (tok.type == Token.Type.COMMA) {
                while (!opStack.isEmpty() && opStack.peek().type != Token.Type.LPAREN) {
                    output.add(opStack.pop());
                }
                if (opStack.isEmpty()) throw new Exception("Mismatched parentheses");
            } else if (tok.type == Token.Type.OPERATOR) {
                String op = tok.value;
                
                // Check if unary
                if ((op.equals("+") || op.equals("-") || op.equals("!")) && 
                    (i == 0 || tokens.get(i - 1).type == Token.Type.OPERATOR || 
                     tokens.get(i - 1).type == Token.Type.LPAREN ||
                     tokens.get(i - 1).type == Token.Type.COMMA ||
                     tokens.get(i - 1).type == Token.Type.TERNARY_Q ||
                     tokens.get(i - 1).type == Token.Type.TERNARY_COLON)) {
                    op = "unary" + op;
                    tok = new Token(Token.Type.OPERATOR, op);
                }
                
                while (!opStack.isEmpty() && opStack.peek().type == Token.Type.OPERATOR) {
                    String top = opStack.peek().value;
                    int prec = PRECEDENCE.get(op);
                    int topPrec = PRECEDENCE.get(top);
                    
                    if ((RIGHT_ASSOC.contains(op) && prec < topPrec) || 
                        (!RIGHT_ASSOC.contains(op) && prec <= topPrec)) {
                        output.add(opStack.pop());
                    } else {
                        break;
                    }
                }
                opStack.push(tok);
            } else if (tok.type == Token.Type.TERNARY_Q) {
                opStack.push(tok);
            } else if (tok.type == Token.Type.TERNARY_COLON) {
                while (!opStack.isEmpty() && opStack.peek().type != Token.Type.TERNARY_Q) {
                    output.add(opStack.pop());
                }
                if (opStack.isEmpty()) throw new Exception("Mismatched ternary operator");
                opStack.pop(); // Remove ?
                opStack.push(new Token(Token.Type.OPERATOR, "?:"));
            } else if (tok.type == Token.Type.LPAREN) {
                opStack.push(tok);
            } else if (tok.type == Token.Type.RPAREN) {
                while (!opStack.isEmpty() && opStack.peek().type != Token.Type.LPAREN) {
                    output.add(opStack.pop());
                }
                if (opStack.isEmpty()) throw new Exception("Mismatched parentheses");
                opStack.pop();
                if (!opStack.isEmpty() && opStack.peek().type == Token.Type.FUNCTION) {
                    output.add(opStack.pop());
                }
            }
        }
        
        while (!opStack.isEmpty()) {
            Token top = opStack.pop();
            if (top.type == Token.Type.LPAREN || top.type == Token.Type.RPAREN) {
                throw new Exception("Mismatched parentheses");
            }
            output.add(top);
        }
        
        return output;
    }
    
    private static Node evaluateRPN(List<Token> rpn, Map<String, String> env) throws Exception {
        Stack<Node> stack = new Stack<>();
        
        for (Token tok : rpn) {
            if (tok.type == Token.Type.NUMBER) {
                stack.push(new Node(tok.value, "int", tok.value));
            } else if (tok.type == Token.Type.BOOLEAN) {
                stack.push(new Node(tok.value, "bool", tok.value));
            } else if (tok.type == Token.Type.VARIABLE) {
                if (!env.containsKey(tok.value)) throw new Exception("Unknown variable");
                String val = env.get(tok.value);
                String type = (val.equals("true") || val.equals("false")) ? "bool" : "int";
                stack.push(new Node(val, type, tok.value));
            } else if (tok.type == Token.Type.FUNCTION) {
                if (tok.value.equals("abs") || tok.value.equals("sgn")) {
                    if (stack.isEmpty()) throw new Exception("Insufficient operands");
                    Node a = stack.pop();
                    if (!a.type.equals("int")) throw new Exception("Type mismatch");
                    int av = Integer.parseInt(a.value);
                    int result = tok.value.equals("abs") ? Math.abs(av) : Integer.compare(av, 0);
                    stack.push(new Node(String.valueOf(result), "int", tok.value + "(" + a.canonical + ")"));
                } else {
                    if (stack.size() < 2) throw new Exception("Insufficient operands");
                    Node b = stack.pop();
                    Node a = stack.pop();
                    if (!a.type.equals("int") || !b.type.equals("int")) throw new Exception("Type mismatch");
                    int av = Integer.parseInt(a.value);
                    int bv = Integer.parseInt(b.value);
                    int result = tok.value.equals("min") ? Math.min(av, bv) : Math.max(av, bv);
                    stack.push(new Node(String.valueOf(result), "int", tok.value + "(" + a.canonical + "," + b.canonical + ")"));
                }
            } else if (tok.type == Token.Type.OPERATOR) {
                String op = tok.value;
                
                if (op.startsWith("unary")) {
                    if (stack.isEmpty()) throw new Exception("Insufficient operands");
                    Node a = stack.pop();
                    String realOp = op.substring(5);
                    
                    if (realOp.equals("!")) {
                        if (!a.type.equals("bool")) throw new Exception("Type mismatch");
                        boolean result = !Boolean.parseBoolean(a.value);
                        stack.push(new Node(String.valueOf(result), "bool", "!" + a.canonical));
                    } else {
                        if (!a.type.equals("int")) throw new Exception("Type mismatch");
                        int av = Integer.parseInt(a.value);
                        int result = realOp.equals("+") ? av : -av;
                        stack.push(new Node(String.valueOf(result), "int", realOp + a.canonical));
                    }
                } else if (op.equals("?:")) {
                    if (stack.size() < 3) throw new Exception("Insufficient operands");
                    Node falseExpr = stack.pop();
                    Node trueExpr = stack.pop();
                    Node cond = stack.pop();
                    
                    if (!cond.type.equals("bool")) throw new Exception("Type mismatch");
                    if (!trueExpr.type.equals(falseExpr.type)) throw new Exception("Type mismatch");
                    
                    boolean condVal = Boolean.parseBoolean(cond.value);
                    Node result = condVal ? trueExpr : falseExpr;
                    String canon = "(" + cond.canonical + " ? " + trueExpr.canonical + " : " + falseExpr.canonical + ")";
                    stack.push(new Node(result.value, result.type, canon));
                } else {
                    if (stack.size() < 2) throw new Exception("Insufficient operands");
                    Node b = stack.pop();
                    Node a = stack.pop();
                    
                    Node result = applyBinaryOp(op, a, b);
                    stack.push(result);
                }
            }
        }
        
        if (stack.size() != 1) throw new Exception("Invalid expression");
        return stack.pop();
    }
    
    private static Node applyBinaryOp(String op, Node a, Node b) throws Exception {
        String canon = "(" + a.canonical + op + b.canonical + ")";
        
        if (op.equals("||") || op.equals("&&")) {
            if (!a.type.equals("bool") || !b.type.equals("bool")) throw new Exception("Type mismatch");
            boolean av = Boolean.parseBoolean(a.value);
            boolean bv = Boolean.parseBoolean(b.value);
            boolean result = op.equals("||") ? (av || bv) : (av && bv);
            return new Node(String.valueOf(result), "bool", canon);
        }
        
        if (op.equals("==") || op.equals("!=")) {
            if (!a.type.equals(b.type)) throw new Exception("Type mismatch");
            boolean result;
            if (a.type.equals("int")) {
                result = Integer.parseInt(a.value) == Integer.parseInt(b.value);
            } else {
                result = Boolean.parseBoolean(a.value) == Boolean.parseBoolean(b.value);
            }
            if (op.equals("!=")) result = !result;
            return new Node(String.valueOf(result), "bool", canon);
        }
        
        if (op.equals("<") || op.equals("<=") || op.equals(">") || op.equals(">=")) {
            if (!a.type.equals("int") || !b.type.equals("int")) throw new Exception("Type mismatch");
            int av = Integer.parseInt(a.value);
            int bv = Integer.parseInt(b.value);
            boolean result = false;
            switch (op) {
                case "<": result = av < bv; break;
                case "<=": result = av <= bv; break;
                case ">": result = av > bv; break;
                case ">=": result = av >= bv; break;
            }
            return new Node(String.valueOf(result), "bool", canon);
        }
        
        if (!a.type.equals("int") || !b.type.equals("int")) throw new Exception("Type mismatch");
        int av = Integer.parseInt(a.value);
        int bv = Integer.parseInt(b.value);
        int result = 0;
        
        switch (op) {
            case "+": result = av + bv; break;
            case "-": result = av - bv; break;
            case "*": result = av * bv; break;
            case "/": 
                if (bv == 0) throw new Exception("Division by zero");
                result = av / bv;
                break;
            case "%": 
                if (bv == 0) throw new Exception("Division by zero");
                result = av % bv;
                break;
            case "^": result = (int) Math.pow(av, bv); break;
            default: throw new Exception("Unknown operator");
        }
        
        return new Node(String.valueOf(result), "int", canon);
    }
    
    private static String buildRPNString(List<Token> rpn) {
        StringBuilder sb = new StringBuilder();
        for (Token tok : rpn) {
            if (sb.length() > 0) sb.append(" ");
            if (tok.type == Token.Type.OPERATOR && tok.value.startsWith("unary")) {
                sb.append(tok.value.substring(5));
            } else {
                sb.append(tok.value);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Map<String, String> env = new HashMap<>();
        env.put("a", "-4");
        
        String expr = "max(3, 1+2) * (a>0 ? 5 : 2)";
        ExprResult result = evaluate(expr, env);
        
        if (result == null) {
            System.out.println("ERROR");
        } else {
            System.out.println("value=" + result.value);
            System.out.println("rpn=" + result.rpn);
            System.out.println("canonical=" + result.canonical);
        }
        
        // Additional test cases
        System.out.println("\n--- Test 2 ---");
        env.put("x", "10");
        result = evaluate("x > 5 ? x * 2 : x + 1", env);
        if (result == null) {
            System.out.println("ERROR");
        } else {
            System.out.println("value=" + result.value + ", rpn=" + result.rpn + ", canonical=" + result.canonical);
        }
        
        System.out.println("\n--- Test 3 ---");
        result = evaluate("2 + 3 * 4 ^ 2", new HashMap<>());
        if (result == null) {
            System.out.println("ERROR");
        } else {
            System.out.println("value=" + result.value + ", rpn=" + result.rpn + ", canonical=" + result.canonical);
        }
    }
}

class ExprResult {
    String value;
    String rpn;
    String canonical;
    
    ExprResult(String value, String rpn, String canonical) {
        this.value = value;
        this.rpn = rpn;
        this.canonical = canonical;
    }
}

class Token {
    enum Type { NUMBER, BOOLEAN, VARIABLE, OPERATOR, LPAREN, RPAREN, COMMA, TERNARY_Q, TERNARY_COLON, FUNCTION }
    Type type;
    String value;
    
    Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }
}

class Node {
    String value;
    String type; // "int" or "bool"
    String canonical;
    
    Node(String value, String type, String canonical) {
        this.value = value;
        this.type = type;
        this.canonical = canonical;
    }
}