

import java.util.Arrays;

public class DungeonPrinces {

    public int calculateMinimumHP(int[][] A) {
        int[][] dp = new int[A[0].length][A.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[A[0].length - 1][A.length - 1] = Math.max(1, 1 - A[A[0].length - 1][A.length - 1]);
        calcHP(0, 0, A, dp);
        return dp[0][0];

    }

    private int calcHP(int i, int j, int[][] hp, int[][] dp) {

        if (i >= hp[0].length || j >= hp.length)
            return Integer.MAX_VALUE;

        if (dp[i][j] == -1) {
            int leftMin = calcHP(i, j + 1, hp, dp);
            int rightMin = calcHP(i + 1, j, hp, dp);
            dp[i][j] = Math.max(1, Math.min(leftMin, rightMin) - hp[i][j]);
        }

        return dp[i][j];

    }

    public static void main(String[] args) {
        DungeonPrinces dungeonPrinces = new DungeonPrinces();
        int[][] hp = {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 }
        };
        System.out.println(dungeonPrinces.calculateMinimumHP(hp));

    }
}
