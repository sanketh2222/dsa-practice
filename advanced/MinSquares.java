package advanced;

public class MinSquares {

    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= A; i ++) {
            int ans = i;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans,(1+ dp[i - j*j]));
            }
            dp[i] = ans;
        } 

        return dp[A];
    }
    public static void main(String[] args) {
        MinSquares minSquares = new MinSquares();
        System.out.println(minSquares.countMinSquares(13));

    }
}
