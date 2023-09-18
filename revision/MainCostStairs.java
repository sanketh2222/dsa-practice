package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainCostStairs {
    public int solve(int[] A) {
        int[] dp = new int[A.length + 1];
        Arrays.fill(dp, -1);
        int ans = climbStairs(A, A.length - 1, 0, dp);
        return ans;
    }

    public ListNode solve(ListNode A) {
        int count = 1;
        ArrayList<Integer> even = new ArrayList<Integer>();
        ListNode ans = A;

        while (A != null) {
            if (count % 2 == 0) {
                even.add(A.val);
            }

            count++;
            A = A.next;
        }

        Collections.reverse(even);
        count = 1;
        A = ans;

        while (A != null) {
            if (count % 2 == 0) {
                A.val = even.get(count / 2 - 1);
            }

            count++;
            A = A.next;
        }

        return ans;
    }

    private int climbStairs(int[] cost, int dest, int currStep, int[] dp) {

        if (currStep >= dest) {
            return 0;
        }

        if (dp[currStep] != -1) {
            return dp[currStep];
        }

        dp[currStep] = Math.min(
                cost[currStep] + climbStairs(cost, dest, currStep + 1, dp),
                cost[currStep + 1] + climbStairs(cost, dest, currStep + 2, dp));

        return dp[currStep];
    }

    public static void main(String[] args) {
        MainCostStairs costStairs = new MainCostStairs();
        int[] arr = { 9, 1, 0, 2, 5, 4 };
        System.out.println(costStairs.solve(arr));
    }
}
