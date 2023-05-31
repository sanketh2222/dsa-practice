import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PalindromePartioning {

    public int minCut(String A) {
        int[] dp = new int[A.length()];
        Arrays.fill(dp, -1);
        int ans = mp(A, 0, A.length(), dp);
        return ans > 0 ? ans - 1 : ans;
    }

    private int mp(String str, int i, int n, int[] dp) {
        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(str, i, j)) {
                int cost = 1 + mp(str, j + 1, n, dp);
                minCost = Math.min(minCost, cost);
            }

        }
        dp[i] = minCost;

        return minCost;
    }

    private boolean isPalindrome(String A, int i, int j) {
        boolean isPalindrome = true;
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        PalindromePartioning palindromePartioning = new PalindromePartioning();
        // System.out.println(palindromePartioning.isPalindrome("aba", 0, 2));
        System.out.println(palindromePartioning.minCut("aba"));
        List<BigDecimal> salesLst = Arrays.asList(null, null, null);
        BigDecimal ans= salesLst.stream().filter(x -> x!= null).reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
        System.out.println(ans);
     

    }
}
