
package revision;

import java.util.Arrays;

public class CoinChange {
    int mod = 1000000007;

    public int solve(int[] A, int B) {
        // return coinchange(A, A.length - 1, B);
        int[][] dp = new int[A.length][B + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // for (int i = 0; i <= B; i++) {
        // dp[0][i] = B % A[0] == 0 ? 1 : 0;
        // }
        dp[0][0] = 1;
        for (int i = 1; i <= B; i++) {
            if (A[0] <= i && i % A[0] == 0) {
                dp[0][i] = 1;
            }
        }
        // return coinChange(A, A.length - 1, B, dp);
        return coinChangeTab(A, B, dp);
        // return coinChange(A, B);
    }

    private int coinChangeTab(int[] arr, int k, int[][] dp) {
        for (int idx = 1; idx < arr.length; idx++) {
            for (int j = 0; j <= k; j++) {
                // int notTake = coinChange(arr, idx - 1, k, dp);
                int notTake = dp[idx - 1][j];

                int take = 0;
                if (arr[idx] <= j) {
                    // take = coinChange(arr, idx, k - arr[idx], dp);
                    take = dp[idx][j - arr[idx]];
                }

                dp[idx][j] = (take % mod + notTake % mod) % mod;
            }
        }
        return dp[arr.length - 1][k];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    private int coinchange(int[] arr, int idx, int k) {
        // if (k == 0) {return 0;}
        if (idx == 0) {
            return k % arr[idx] == 0 ? 1 : 0;
        }

        int notTake = coinchange(arr, idx - 1, k);

        int take = 0;
        if (k - arr[idx] >= 0) {
            take = coinchange(arr, idx, k - arr[idx]);
        }

        return notTake + take;
    }

    private int coinChange(int[] arr, int idx, int k, int[][] dp) {
        if (idx == 0) {
            dp[idx][k] = k % arr[idx] == 0 ? 1 : 0;
            return dp[idx][k];
        }

        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }

        int notTake = coinChange(arr, idx - 1, k, dp);

        int take = 0;
        if (k - arr[idx] >= 0) {
            take = coinChange(arr, idx, k - arr[idx], dp);
        }

        dp[idx][k] = (take % mod + notTake % mod) % mod;
        return dp[idx][k];
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 5, 6 };
        int B = 10;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.solve(A, B));
        boolean[] barr = new boolean[10];
        Arrays.fill(barr, true);
    }
}
