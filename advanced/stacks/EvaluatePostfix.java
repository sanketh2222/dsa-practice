package stacks;

import java.util.Stack;

public class EvaluatePostfix {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2; // Division truncates towards zero
            default:
                return 0; // Invalid operator, should not reach here in a valid RPN expression
        }
    }

    public static void main(String[] args) {
        EvaluatePostfix postFixEvaluator = new EvaluatePostfix();
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println("Result: " + postFixEvaluator.evalRPN(tokens)); // Output: 22
        Stack<Integer> st = new Stack<>();
        System.out.println(st.peek());
    }
}
