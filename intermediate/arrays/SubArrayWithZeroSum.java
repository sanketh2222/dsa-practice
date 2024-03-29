import java.util.HashMap;
import java.util.Map;

import arrays.SubArrayWithZeroSum;

public class SubArrayWithZeroSum {

    public static int solve(int[] A) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        long[] prefixSum = new long[A.length];
        // sum vs freq
        prefixMap.put(0L, 1);
        long sum = 0;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            prefixSum[i] = sum;
        }

        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixMap.containsKey(prefixSum[i])) {
                int freq = prefixMap.get(prefixSum[i]);
                count += freq;
                prefixMap.put(prefixSum[i], ++freq);

            } else {
                prefixMap.put(prefixSum[i], 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 2, -2 };
        int ans = SubArrayWithZeroSum.solve(arr);
        System.out.println(ans);
    }
}
