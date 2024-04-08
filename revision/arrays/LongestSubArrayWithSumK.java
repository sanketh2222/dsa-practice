package revision.arrays;

public class LongestSubArrayWithSumK {

    public int solve(int[] A, int B) {
        int n = A.length;
        int sum = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            while (sum > B) {
                sum -= A[start];
                start++;
            }
            if (sum == B) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubArrayWithSumK longestSubArrayWithSumK = new LongestSubArrayWithSumK();
        int[] arr = { 1, 2, 3, 4, 5 };
        int B = 10;
        System.out.println(longestSubArrayWithSumK.solve(arr, B));
    }
}
