import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lis(final int[] A) {
        int[] dp = new int[A.length];
        dp[0] = 1;
        // int ans = 0;

        for (int i = 1; i < A.length; i++) {
            int s = 0;
            for (int j = i - 1; j >= 0; j--) {

                if (A[i] > A[j]) {
                    s = Math.max(s, dp[j]);
                }

            }
            dp[i] = s + 1;
        }

        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println(lis.lis(A));
    }
}
