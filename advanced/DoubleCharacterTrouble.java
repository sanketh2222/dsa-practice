

import java.util.Stack;

public class DoubleCharacterTrouble {

    public static String solve(String A) {
        Stack<Character> charStack = new Stack<>();
        StringBuffer resultString = new StringBuffer();
        int n = A.length();

        charStack.push(A.charAt(0));
        for (int i = 1; i < n; i++) {
            char incommingChar = A.charAt(i);
            if (!charStack.isEmpty() && incommingChar == charStack.peek().charValue()) {
                charStack.pop();
            } else {
                charStack.push(incommingChar);
            }

        }

        while (!charStack.isEmpty()) {
            resultString.append(charStack.pop());
        }

        return resultString.reverse().toString();
    }

    public static void main(String[] args) {
        String s = DoubleCharacterTrouble.solve("aaaaa");
        System.out.println(s);

    }
}
