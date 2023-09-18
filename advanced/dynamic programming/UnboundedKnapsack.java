

import static java.lang.Math.max;

import java.util.Arrays;

public class UnboundedKnapsack {

    public int solve(int A, int[] B, int[] C) {
        int[][] ks = new int[B.length + 1][A + 1];
        for (int[] row : ks) {
            Arrays.fill(row, -1);
        }
        knapsack(B, C, B.length - 1, A, ks);
        return ks[B.length - 1][A];
    }

    private int knapsack(int[] v, int[] w, int i, int j, int[][] ks) {

        if (i == -1 || j == -1)
            return 0;

        if (ks[i][j] == -1) {
            // exclude the i th item
            int a = knapsack(v, w, i - 1, j, ks);
            if (j >= w[i]) {
                // include the ith item
                a = max(a, v[i] + knapsack(v, w, i, j - w[i], ks));
            }
            ks[i][j] = a;
        }

        return ks[i][j];

    }

    public static void main(String[] args) {
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        int A = 10;
        int[] B = { 6, 7 };
        int[] C = { 5, 5 };
        System.out.println(unboundedKnapsack.solve(A, B, C));

    }
}
