package revision;

import java.util.Arrays;

public class RegularExpressionMatch {

    public int isMatch(final String A, final String B) {
        int[][] dp = new int[B.length()][A.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return matchingUtil(B, A, B.length() - 1, A.length() - 1, dp);
    }

    public int isMatched(final String A, final String B) {
        int[][] dp = new int[A.length()][B.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return matchingUtil(A, B, A.length() - 1, B.length() - 1, dp);
    }

    private int matchingUtil(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return 1;
        }
        if (i < 0 && j >= 0) {
            return 0;
        }
        if (j < 0 && i >= 0) {
            return isAllStar(s1, i) ? 1 : 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            dp[i][j] = matchingUtil(s1, s2, i - 1, j - 1, dp);
            return dp[i][j];
        } else {

            if (s1.charAt(i) == '*') {
                return (matchingUtil(s1, s2, i - 1, j, dp) == 1) || (matchingUtil(s1, s2, i, j - 1, dp) == 1) ? 1
                        : 0;
            } else
                return 0;

        }

    }

    int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;

        if (i < 0 && j >= 0)
            return 0;

        if (j < 0 && i >= 0)
            return isAllStar(S1, i) ? 1 : 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

        else {
            if (S1.charAt(i) == '*')
                return (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1
                        || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            else
                return 0;
        }
    }

    private boolean isAllStar(String s, int i) {
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "bcaccbabaa";// bcaccbabaa
        String s2 = "bb*c?c*";// bb*c?c*?
        RegularExpressionMatch expressionMatch = new RegularExpressionMatch();
        // System.out.println(expressionMatch.isMatched(s1, s2));
        System.out.println(expressionMatch.isMatch(s1, s2));
    }
}
