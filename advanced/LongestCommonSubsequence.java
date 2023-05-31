

import java.util.Arrays;

import java.util.Arrays;

public class LongestCommonSubsequence {
    StringBuffer buffer = new StringBuffer();
    public int solve(String A, String B) {
  
        int[][] dp = new int[A.length()][B.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        LCS(A, B, A.length() - 1, B.length() - 1, dp);
        return dp[A.length() - 1][A.length() - 1];
    }

    private int LCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i == -1 || j == -1) {
            return 0;
        }

        if (dp[i][j] == -1) {

            if (s1.charAt(i) == s2.charAt(j)) {
                buffer.append(s2.charAt(i));
                dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
      

            } else {
                dp[i][j] = Math.max(LCS(s1, s2, i - 1, j, dp), LCS(s1, s2, i, j - 1, dp));
            }
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence commonSubsequence = new LongestCommonSubsequence();
        String A = "bebdeeedaddecebbbbbabebedc";
        String B = "abaaddaabbedeedeacbcdcaaed";
        System.out.println(commonSubsequence.solve(A, B));

    }
}
