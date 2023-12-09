package arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquilibriumIndex {

    public int solve(ArrayList<Integer> A) {
        Integer[] prefixSumArray = new Integer[A.size()];

        prefixSumArray[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + A.get(i);
        }

        for (int i = 0; i < A.size(); i++) {
            int sumLeft = 0, sumRight = 0;
            sumLeft = getSumLeft(i, prefixSumArray, A);
            sumRight = getSumRight(i, A.size(), prefixSumArray);

            if (sumLeft == sumRight) {
                return i;
            }

        }

        return -1;

    }

    public int getSumLeft(int index, Integer[] prefixSumArray, ArrayList<Integer> A) {
        if (index == 0)
            return 0;

        return prefixSumArray[index - 1];
    }

    public int getSumRight(int index, int size, Integer[] prefixSumArray) {
        if (index == size - 1)
            return 0;

        return prefixSumArray[size - 1] - prefixSumArray[index];
    }

    public int solve(int[] A) {
        int n = A.length;
        int[] psum = new int[n];
        psum[0] = A[0];

        //Compute prefix sum
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + A[i];
        }

        for (int i = 0; i < n; i++) {
            
            int leftSum = 0;

            if (i > 0) {
                leftSum = psum[i - 1];
            }

            int rightSum = psum[n - 1] - psum[i];

            if (leftSum == rightSum) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        EquilibriumIndex solution = new EquilibriumIndex();

        List<Integer> A = Arrays.asList(-7, 1, 5, 2, -4, 3, 0);
        int res = solution.solve(new ArrayList<>(A));
        // System.out.println(res);
    }
}
