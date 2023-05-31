

import java.util.Arrays;

public class MaxModValue {
    

    public int solve(int[] A) {
        int start = 0, end = 1, n = A.length;

        int ans = Integer.MIN_VALUE;
        int maxMod = 0;

        if (n == 1)
            return A[0];
        Arrays.sort(A);
        while (end < n) {
            maxMod = Math.max(A[start] % A[end] , A[end] % A[start]);
            ans = Math.max(maxMod,ans);
            end++;
            start++;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr  = { 927, 707, 374, 394, 279, 799, 878, 937, 431, 112 };
        MaxModValue maxModValue = new MaxModValue();
        int ans = maxModValue.solve(arr);
        System.out.println(ans);
        
    }
}
