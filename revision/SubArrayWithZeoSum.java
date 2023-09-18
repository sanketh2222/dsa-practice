package revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWithZeoSum {

    public static int solve(int[] A) {
        Set<Long> prefixSumHashSet = new HashSet<>();
        long sum = A[0];
        prefixSumHashSet.add(sum);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 0)
                return 1;
            sum += A[i];
            if (!prefixSumHashSet.add(sum) || sum == 0) {
                return 1;
            }

        }
        return prefixSumHashSet.contains(0L) ? 1 : 0;
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int[] ps = buildPrefixSum(nums);
        Map<Integer, Integer> hashSet = new HashMap<>();

        for (int i = 0; i < ps.length; i++) {
            if (ps[i] == 0) {
                return i + 1;

            } else if (hashSet.containsKey(ps[i])) {
                maxLen = Math.max(maxLen, i - hashSet.get(ps[i]));

            } else {
                hashSet.put(ps[i], i);
            }

        }

        return maxLen;

    }

    private static int[] buildPrefixSum(int[] arr) {
        int[] ps = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : arr[i];
            ps[i] = sum;
        }

        return ps;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 1 };
        System.out.println(solve(arr));
        int[] nums = { 0, 1, 0, 1 };
        findMaxLength(nums);
    }
}
