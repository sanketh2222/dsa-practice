package revision;

import java.util.Arrays;

public class KnapSack {

    public int solve(int[] A, int[] B, int C) {
        // dp state :- dp[i][j] : till index i and j is the limit of wt that can be
        // picked
        // dp[i][j] :- till index i whats the wt that can be picked
        int[][] dp = new int[A.length][C + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return ks(B, A, dp, A.length - 1, C);
    }

    // Assumption: it will return the max weight that can be picked based on the
    // params passed
    // i -> index of the value arr and j is the total weight remaining
    private int ks(int[] wt, int[] v, int[][] dp, int i, int j) {
        // base case

        if (i == -1 || j == -1) {
            return 0;
        }

        // dp expression
        // either pick the current elemet: total weight limit will be reduced and value
        // will be apped

        if (dp[i][j] == -1) {
            int ans = -1;
            // if picking the wt should be less than the max wt limit
            if (wt[i] <= j)
                ans = v[i] + ks(wt, v, dp, i - 1, j - wt[i]);
            // or leave it :- no value add and total wt limit is not reduced
            dp[i][j] = Math.max(ans, ks(wt, v, dp, i - 1, j));
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        int[] A = { 359, 963, 465, 706, 146, 282, 828, 962, 492 };
        int[] B = { 96, 43, 28, 37, 92, 5, 3, 54, 93 };
        int C = 383;
        System.out.println(knapSack.solve(A, B, C));// 5057
    }
}
