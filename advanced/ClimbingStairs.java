

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return totalSteps(0, n, dp);

    }

    private int totalSteps(int currStep, int targetStep, int[] dp) {
        if (currStep == targetStep) {
            return 1;
        }

        if (currStep > targetStep) {
            return 0;
        }

        if (dp[currStep] == -1) {
            dp[currStep] = (totalSteps(currStep + 1, targetStep, dp)
                    + totalSteps(currStep + 2, targetStep, dp));
        }

        return dp[currStep];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));

    }
}
