package revision;

import java.util.Arrays;

public class RodCutting {

    public int rc(int[] dp, int[] p, int i) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] == -1) {
            int maxCost = -1;
            for (int j = 1; j <= i; j++) {
                maxCost = Math.max(maxCost, p[j - 1] + rc(dp, p, i - j));
            }

            dp[i] = maxCost;
        }

        return dp[i];
    }

    public static void main(String[] args) {
        RodCutting cutting = new RodCutting();
        int[] p = { 2, 5, 7, 8, 10 };
        int[] dp = new int[p.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(cutting.rc(dp, p, 5));
        System.out.println(dp);

    }
}
