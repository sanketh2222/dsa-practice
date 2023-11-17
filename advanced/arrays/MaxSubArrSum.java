public class MaxSubArrSum {
    // Kadens Algo
    public int maxSubArray(final int[] A) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            ans = Math.max(ans, sum);

            if (sum < 0)
                sum = 0;
        }

        return ans;
    }
}
