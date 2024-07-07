import java.util.Stack;

public class ParenthesesValidator {

    //https://hackmd.io/mpnE1tvYQdOunFkzpNNqOA#Balanced-Parenthesis-Implementation
    public static boolean isValidParentheses(String sequence) {
        // Initialize an empty stack
        Stack<Character> stack = new Stack<>();

        // For each character 'char' in the sequence
        for (char incomingCh : sequence.toCharArray()) {
            // If 'char' is an opening parenthesis ('(', '{', '[')
            if (incomingCh == '(' || incomingCh == '{' || incomingCh == '[') {
                stack.push(incomingCh);
            }
            // Else if 'char' is a closing parenthesis (')', '}', ']')
            else if (incomingCh == ')' || incomingCh == '}' || incomingCh == ']') {
                // If the stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack into 'top'
                char top = stack.pop();
                // If 'top' is not of the corresponding opening type for 'char'
                if ((incomingCh == ')' && top != '(') ||
                        (incomingCh == '}' && top != '{') ||
                        (incomingCh == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is not empty
        if (!stack.isEmpty()) {
            return false;
        }

        // Else
        return true;
    }

    public static void main(String[] args) {
        String sequence = "([{}])";
        System.out.println("Is valid: " + isValidParentheses(sequence)); // Should print: Is valid: true

        sequence = "([{}]))";
        System.out.println("Is valid: " + isValidParentheses(sequence)); // Should print: Is valid: false
    }
}
