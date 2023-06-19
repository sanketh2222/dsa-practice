

public class MaxProductSubarray {

    public int maxProduct(final int[] A) {
        // We need to keep track of minimum and maximum products for every iteration
        // since we can have negative values in the given array
        // We can't use Kadane's Algorithm, because it is meant for Max SubArray Sum
        int max = A[0]; // To keep track of the maximum value in the array
        int min = A[0]; // To keep track of the minimum value in the array
        int n = A.length;
        int ans = A[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(A[i], Math.max(A[i] * max, A[i] * min));
            min = Math.min(A[i], Math.min(A[i] * max, A[i] * min));
            max = temp;
            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int[] arr = { 0, 0, 0, -3, -2, 0};
        int ans = maxProductSubarray.maxProduct(arr);
        System.out.println(ans);

    }
}
