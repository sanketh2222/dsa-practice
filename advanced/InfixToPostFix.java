package advanced;

import java.util.Stack;
import org.junit.Test;

public class InfixToPostFix {

    static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    // InfixToPostFixConversion
    public static String solve(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        String postFix = infixToPostFix.solve(A);
        System.out.println(postFix); // expected: "abcd^e-fgh*+^*+i-"
    }

    @Test
    public void expresion1() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        String postFix = infixToPostFix.solve(A);
        System.out.println(postFix);
        String expected = "abcd^e-fgh*+^*+i-";
        assert expected.equals(postFix);
    }

    @Test
    public void expresion2() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String A = "x^y/(a*z)+b";
        String postFix = infixToPostFix.solve(A);
        System.out.println(postFix);
        String expected = "xy^az*/b+";
        assert expected.equals(postFix);
    }
}