

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class InfixToPostFixWrong {

    private Map<Character, Integer> setPrecendences() {
        Map<Character, Integer> precenanceMap = new HashMap<>();
        precenanceMap.put('^', 4);
        precenanceMap.put('(', 3);
        precenanceMap.put('/', 2);
        precenanceMap.put('*', 2);
        precenanceMap.put('+', 1);
        precenanceMap.put('-', 1);
        return precenanceMap;

    }

    public String solve(String A) {
        List<Character> operators = Arrays.asList('^', '(', '/', '*', '+', '-');
        Stack<Character> stack = new Stack<Character>();
        StringBuilder postFixExpression = new StringBuilder();
        int n = A.length();
        Map<Character, Integer> precenanceMap = setPrecendences();
        for (int i = 0; i < n; i++) {

            char incommingChar = A.charAt(i);

            if (operators.contains(incommingChar) && stack.isEmpty()) {
                stack.push(incommingChar);

            } else if (operators.contains(incommingChar) && incommingChar != ')') {

                int currPrecedance = precenanceMap.get(incommingChar);
                int tosPrecedence = precenanceMap.get(stack.peek());

                handleOperators(stack, postFixExpression, incommingChar, currPrecedance, tosPrecedence, precenanceMap);

            } else if (incommingChar == ')') {
                // pop the stack till you find ( character
                while (!stack.isEmpty() && stack.peek().charValue() != '(') {
                    postFixExpression.append(stack.pop());
                }

                // pop ( character from stack without appending it to result
                if (!stack.isEmpty())
                    stack.pop();

            } else {
                postFixExpression.append(incommingChar);
            }
        }

        emptyStack(stack, postFixExpression);

        return postFixExpression.toString();

    }

    private void handleOperators(Stack<Character> stack, StringBuilder postFixExpression, char incommingChar,
            int currPrecedance, int tosPrecedence, Map<Character, Integer> precedanceMap) {
        if (currPrecedance >= tosPrecedence || (stack.peek().charValue() == '(' && tosPrecedence < 4)) {
            stack.push(incommingChar);

        } else {
            // Empty stack till higher prec operator other than (
            // is at the tos and add the expression
            // tos ^ and incoming ( -> should be inserted to stack
            while (!stack.isEmpty()) {
                char tos = stack.peek();
                if (incommingChar == '(' && tos == '^') {
                    stack.push(incommingChar);
                } else if (tos != '(' && (precedanceMap.get(incommingChar) < precedanceMap.get(stack.peek()))) {
                    char popedOperator = stack.pop();
                    postFixExpression.append(popedOperator != '(' ? popedOperator : "");
                } else {
                    break;
                }
            }
            if (stack.peek() != '(')
                stack.push(incommingChar);
        }
    }

    private void emptyStack(Stack<Character> stack, StringBuilder postFixExpression) {
        while (!stack.isEmpty()) {
            char popedOperator = stack.pop();
            postFixExpression.append(popedOperator != '(' ? popedOperator : "");
        }
    }

    public static void main(String[] args) {
        InfixToPostFixWrong wrong = new InfixToPostFixWrong();
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        String postFix = wrong.solve(A);
        System.out.println(postFix);
        // abcd^*e-^fgh*+i-
        // abcd^e-fgh*+^*+i- expected

    }

    // @Test
    public void expresion11() {
        InfixToPostFixWrong wrong = new InfixToPostFixWrong();
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        String postFix = wrong.solve(A);
        System.out.println(postFix);
        String expected = "abcd^e-fgh*+^*+i";
        assert expected.equals(postFix);
    }

    // @Test
    public void expresion22() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String A = "x^y/(a*z)+b";
        String postFix = infixToPostFix.solve(A);
        System.out.println(postFix);
        String expected = "xy^az*/b+";
        assert expected.equals(postFix);
    }
}
