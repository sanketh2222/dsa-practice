package revision;

import java.util.Stack;

/*
 * Laregst area in hsitogram
 */
public class Histogram {

    public int largestRectangleArea(int[] A) {
        // build nse from left
        // build nse from right
        // for rach of the bar find the max length from left and right
        int[] nseLeft = buildNseLeft(A);
        int[] nseRight = buildNseRight(A);
        int maxArea = 0;

        for (int i = 0; i < A.length; i++) {

            int width = Math.max(nseRight[i] - nseLeft[i] - 1, 1);
            int area = width * A[i];
            maxArea = Math.max(area, maxArea);

        }

        return maxArea;
    }

    private int[] buildNseLeft(int[] A) {
        int[] nse = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nse[i] = -1;

            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }

        return nse;
    }

    private int[] buildNseRight(int[] A) {
        int[] nse = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nse[i] = A.length;

            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);

        }

        return nse;

    }

    public static void main(String[] args) {
        Histogram h = new Histogram();
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        System.out.println(h.largestRectangleArea(arr));
    }
}
