

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robHouse(0, nums, dp);
    }

    private int robHouse(int currHouse, int[] cost, int[] dp) {

        if (currHouse >= cost.length)
            return 0;

        if (dp[currHouse] == -1) {
            dp[currHouse] = Math.max(
                    cost[currHouse] + robHouse(currHouse + 2, cost, dp),
                    robHouse(currHouse + 1, cost, dp));
        }

        return dp[currHouse];

    }

    public static void main(String[] args) {

    }
}
