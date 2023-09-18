

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        editDistance(A, B, A.length() - 1, B.length() - 1, dp);

        return dp[A.length() - 1][B.length() - 1];
    }

    private int editDistance(String s1, String s2, int i, int j, int[][] dp) {
        if (i == -1 && j == -1) {
            return 0;
        }

        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (dp[i][j] == -1) {

            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = editDistance(s1, s2, i - 1, j - 1, dp);

            } else {
                dp[i][j] = 1 + Math.min(editDistance(s1, s2, i, j - 1, dp),
                        Math.min(editDistance(s1, s2, i - 1, j - 1, dp), editDistance(s1, s2, i - 1, j, dp)));
            }
        }

        return dp[i][j];

    }

    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        String A = "aaa";
        String B = "aa";
        System.out.println(distance.minDistance(A, B));

    }
}
