package revision;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {

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

    

    public static void main(String[] args) {
        LongestSubArraySum arraySum = new LongestSubArraySum();
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int B = 15;
        System.out.println(arraySum.solve(arr, B));
    }
}
