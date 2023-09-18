package revision;

import java.util.Arrays;

public class StockBuySellII {

    public int maxProfit(final int[] A) {

        long[][] dp = new long[A.length][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        int n = A.length;
        long profit = getMaxProfit(A, 0, 0, dp);
        return (int) profit;
    }

    private long getMaxProfit(int[] arr, int idx, int buy, long[][] dp) {
        // 0-> can buy , 1 means cant buy
        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        long maxProfit = 0;
        if (buy == 1) {// sell / dont sell
            maxProfit = Math.max(arr[idx] + getMaxProfit(arr, idx + 1, 0, dp),
                    getMaxProfit(arr, idx + 1, 1, dp));

        } else {
            maxProfit = Math.max(-arr[idx] + getMaxProfit(arr, idx + 1, 1, dp),
                    getMaxProfit(arr, idx + 1, 0, dp));
        }

        dp[idx][buy] = maxProfit;

        return dp[idx][buy];
    }

    public static void main(String[] args) {
        
    }
}
