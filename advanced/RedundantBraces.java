

import java.util.Stack;

public class RedundantBraces {

    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();
        stack.add(A.charAt(0));
        for (int i = 1; i < n; i++) {
            char c = A.charAt(i);
            if (c == '(' && stack.peek() == '(') {
                return 1;
            } else {
                stack.add(c);
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        
    }
}
