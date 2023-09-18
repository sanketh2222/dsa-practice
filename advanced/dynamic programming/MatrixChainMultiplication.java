

import java.util.Arrays;

public class MatrixChainMultiplication {

    public int solve(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return mcm(1, A.length - 1, dp, A);
    }

    private int mcm(int i, int j, int[][] dp, int[] v) {
        if (i == j)
            return 0;

        if (dp[i][j] == -1) {

            int a = Integer.MAX_VALUE;
            for (int k = i; k <= j - 1; k++) {
                a = Math.min(a, (mcm(i, k, dp, v) + mcm(k + 1, j, dp, v)) + (v[i - 1] * v[j] * v[k]));
            }
            dp[i][j] = a;

        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] A = { 40, 20, 30, 10, 30 };
        MatrixChainMultiplication chainMultiplication = new MatrixChainMultiplication();
        System.out.println(chainMultiplication.solve(A));

    }
}
