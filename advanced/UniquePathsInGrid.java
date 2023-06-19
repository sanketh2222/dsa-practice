import java.util.HashMap;
import java.util.Map;

public class UniquePathsInGrid {

    public int uniquePathsWithObstacles(int[][] A) {
        int colSize = A[0].length;
        int rowSize = A.length;

        int[][] dp = new int[rowSize][colSize];
        dp[0][0] = 1;

        if (A.length == 1 && A[0].length == 1 && A[0][0] == 0)
            return 1;

        if (A.length == 1 && A[0].length == 1 && A[0][0] == 1)
            return 0;

        for (int i = 1; i < rowSize; i++) {
            if (A[i][0] == 1) {
                dp[i][0] = 1;

            } else {
                break;
            }
        }

        for (int j = 0; j < colSize; j++) {
            if (A[0][j] == 1) {
                dp[0][j] = 1;

            } else {
                break;
            }
        }

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {

                if (A[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[rowSize - 1][colSize - 1];
    }

    public int solve(int[] A) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                ans = Math.min(ans, Math.abs(i - hm.get(A[i])));
            } else {
                hm.put(A[i], i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        UniquePathsInGrid pathsInGrid = new UniquePathsInGrid();
        int[][] grid = { { 0, 0 } };
        System.out.println(pathsInGrid.uniquePathsWithObstacles(grid));
        System.out.println("".toString());
        System.out.println(-1 % 20);
        int[] A = { 7, 1, 3, 4, 1, 7 };
        System.out.println(pathsInGrid.solve(A));
        System.out.println("1a".compareTo("a1"));
        System.out.println("sanke".compareTo("a"));
        boolean isNumeric = "123".chars().allMatch( Character::isDigit );
        System.out.println(isNumeric);
    }
}
