package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElement {

    public int[] prevSmaller(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> previousSmallerValuesStack = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {

            // if (!previousSmallerValuesStack.isEmpty() && previousSmallerValuesStack.peek() < A[i]) {
            //     ans[i] = previousSmallerValuesStack.peek();

            // }

            while (!previousSmallerValuesStack.isEmpty() && previousSmallerValuesStack.peek() >= A[i]) {
                previousSmallerValuesStack.pop();
            }

            ans[i] = previousSmallerValuesStack.isEmpty() ? -1 : previousSmallerValuesStack.peek();

            previousSmallerValuesStack.push(A[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        NearestSmallestElement nse = new NearestSmallestElement();
        int[] arr = { 4, 5, 2, 10, 8 };//NSL
        int[] ans = nse.prevSmaller(arr);
        Arrays.stream(ans).forEach(System.out::println);
        

    }
}
