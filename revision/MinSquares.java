package revision;

import java.util.LinkedList;
import java.util.Queue;

public class MinSquares {
    
    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];

        dp[0] = 0;

        // dp expression dp[i] = 1 + dp[i - j * j]
        for (int i = 1; i <= A; i++) {
            int ans = i;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, dp[i - j * j] + 1);
            } 
            dp[i] = ans;
        }

        return dp[A];
    }

    public static void main(String[] args) {
        MinSquares minSquares = new MinSquares();
        System.out.println(minSquares.countMinSquares(13));
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
 
        for (Integer integer : q) {
            System.out.println(integer);
        }

        
    }
}
