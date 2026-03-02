/** MAIN CLASS - UseCase13PalindromeCheckerApp

 Use Case 13: Performance Comparison of Palindrome Algorithms

 Description:
 This class compares the execution time of different palindrome checking algorithms
 (Stack, Deque, Recursive) using System.nanoTime().
 It demonstrates algorithm performance analysis in Java.

 Key Concepts:
 - System.nanoTime() for precise timing
 - Algorithm performance comparison
 - Strategy pattern for modular algorithms
 - Case-insensitive & space-ignored checking

 @author Sourav Kumar
 @version 13.0
 **/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Strategy interface
interface PalindromeStrategy {
    boolean check(String text);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : cleaned.toCharArray()) stack.push(ch);
        for (char ch : cleaned.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : cleaned.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Recursive implementation
class RecursiveStrategy implements PalindromeStrategy {

    private boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }
}

// Context class
class PalindromeCheckerClass {
    private PalindromeStrategy strategy;

    public PalindromeCheckerClass(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.check(text);
    }

    // Method to measure execution time
    public long measureExecutionTime(String text) {
        long start = System.nanoTime();
        checkPalindrome(text);
        long end = System.nanoTime();
        return end - start; // nanoseconds
    }
}

// Demo
public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        PalindromeCheckerClass checker = new PalindromeCheckerClass(new StackStrategy());
        long stackTime = checker.measureExecutionTime(input);
        System.out.println("StackStrategy result: " + checker.checkPalindrome(input) +
                " | Execution time: " + stackTime + " ns");

        checker.setStrategy(new DequeStrategy());
        long dequeTime = checker.measureExecutionTime(input);
        System.out.println("DequeStrategy result: " + checker.checkPalindrome(input) +
                " | Execution time: " + dequeTime + " ns");

        checker.setStrategy(new RecursiveStrategy());
        long recursiveTime = checker.measureExecutionTime(input);
        System.out.println("RecursiveStrategy result: " + checker.checkPalindrome(input) +
                " | Execution time: " + recursiveTime + " ns");
    }
}