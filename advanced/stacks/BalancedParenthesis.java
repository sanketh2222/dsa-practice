package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedParenthesis {

    public static int solve(String A) {
        Stack<Character> parenthesisStack = new Stack<>();
        int n = A.length();
        List<Character> endingParenthisis = Arrays.asList(')', '}', ']');
        List<Character> startingParenthisis = Arrays.asList('(', '{', '[');

        for (int i = 0; i < n; i++) {
            boolean isEndingBracket = endingParenthisis.contains(A.charAt(i));
            if (isEndingBracket && parenthesisStack.size() < 1) {
                return 0;
            } else if (isEndingBracket) {
                Character startingChar = startingParenthisis.get(endingParenthisis.indexOf(A.charAt(i)));
                char ans = startingChar == parenthesisStack.peek().charValue() ? parenthesisStack.pop() : '1';
            } else {
                parenthesisStack.push(A.charAt(i));
            }
        }

        return parenthesisStack.size() > 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        String expression = "(){";
        System.out.println(BalancedParenthesis.solve(expression));

    }
}
