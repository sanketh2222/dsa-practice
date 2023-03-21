package advanced;

import java.util.Stack;

public class PassGame {

    // 0 means pop other than that just keep inserting and retun tos
    public static int solve(int A, int B, int[] C) {
        Stack<Integer> passes = new Stack<>();
        passes.add(B);
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                passes.pop();
            } else {
                passes.push(C[i]);
            }
        }

        return passes.peek();
    }

    public static void main(String[] args) {
        int A = 10;
        int B = 38;
        int[] C = { 23, 0, 2, 0, 39, 28, 19, 0, 0, 0 };
        System.out.println(PassGame.solve(A, B, C));
    }
}
