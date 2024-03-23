package stacks;

import java.util.Stack;

//nearest greater element
public class NextGreaterElement {

    public int[] nextGreater(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> st = new Stack<>();
        int n = A.length;

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && A[i] >= st.peek()) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(A[i]);

        }

        return ans;

    }

    public static void main(String[] args) {

        int[] A = { 34, 35, 27, 42, 5, 28, 39, 20, 28  };
        int[] ans = new NextGreaterElement().nextGreater(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
