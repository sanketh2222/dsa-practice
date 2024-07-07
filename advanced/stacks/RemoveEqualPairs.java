import java.util.Stack;

public class RemoveEqualPairs {

    // https://hackmd.io/mpnE1tvYQdOunFkzpNNqOA#Problem-4-Remove-equal-pair-of-consecutive-elements-till-possible
    public static String removeEqualPairs(String s) {
        // Initialize an empty stack
        Stack<Character> stack = new Stack<>();

        // For each character 'char' in s
        for (char incomingCh : s.toCharArray()) {
            // If the stack is not empty and 'char' matches the character at the top of the
            // stack
            if (!stack.isEmpty() && stack.peek() == incomingCh) {
                // Pop the element from the stack
                stack.pop();
            } else {
                // Push 'char' onto the stack
                stack.push(incomingCh);
            }
        }

        // Initialize an empty string 'result'
        StringBuilder result = new StringBuilder();

        // While the stack is not empty
        while (!stack.isEmpty()) {
            // Pop an element from the stack and prepend it to 'result'
            result.insert(0, stack.pop());
        }

        // Return 'result'
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println("Result: " + removeEqualPairs(s)); // Should print: Result: ca

        s = "aabbcc";
        System.out.println("Result: " + removeEqualPairs(s)); // Should print: Result: (empty string)
    }
}
