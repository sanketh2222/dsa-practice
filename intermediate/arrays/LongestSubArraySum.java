package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {

    // Given an array of integers A of size N and an integer B.
    // Find the length of the longest subarray having sum equal to B.
    // geek: https://www.geeksforgeeks.org/longest-sub-array-sum-k/
    public int solve(int[] A, int B) {
        int[] ps = buildPrefixSum(A);
        Map<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            hashMap.put(ps[i], i);

            if (ps[i] == B) {
                ans = Math.max(ans, i + 1);

            } else if (hashMap.containsKey(ps[i] - B)) {
                ans = Math.max(ans, i - hashMap.get(ps[i] - B) + 1);
            }
        }

        return ans;
    }

    private int[] buildPrefixSum(int[] arr) {
        int sum = 0;
        int[] ps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ps[i] = sum;

        }

        return ps;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        LongestSubArraySum arraySum = new LongestSubArraySum();
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int B = 15;
        System.out.println(arraySum.solve(arr, B));
    }
}
