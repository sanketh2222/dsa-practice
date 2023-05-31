

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class LargestAreaRectangle {


    private void performStackOperations(int[] arr, Stack<Integer> stack, int[] ans, int i, boolean isNsr) {
        int MIN_INDEX_VALUE = isNsr ? arr.length : -1;
        
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }

        ans[i] = stack.isEmpty() ? MIN_INDEX_VALUE : stack.peek();

        stack.push(i);
    }

    private int[] getNsl(int[] arr) {
        Stack<Integer> nslStack = new Stack<Integer>();
        int[] nsl = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            performStackOperations(arr, nslStack, nsl, i,false);
        }
        return nsl;
    }

    private int[] getNsr(int[] arr) {
        Stack<Integer> nsrStack = new Stack<>();
        int[] nsr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            performStackOperations(arr, nsrStack, nsr, i,true);
        }
        return nsr;

    }

    public int largestRectangleArea(int[] A) {
        int[] nsl = getNsl(A);
        int[] nsr = getNsr(A);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int width = Math.max((nsr[i] - nsl[i] - 1), 1);
            int area = A[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27 };
        LargestAreaRectangle largestAreaRectangle = new LargestAreaRectangle();
        System.out.println(largestAreaRectangle.largestRectangleArea(arr));
   

    }
}
