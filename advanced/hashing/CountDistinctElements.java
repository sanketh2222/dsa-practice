package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElements {
    // Distinct elements in every window of size K using hashing
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n - B + 1];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ans[index++] = map.size();
        int start = 1, end = B;
        while (end < n) {

            map.put(A[end], map.getOrDefault(A[end], 0) + 1);

            if (map.get(A[start - 1]) == 1) {
                map.remove(A[start - 1]);
            } else {
                map.put(A[start - 1], map.get(A[start - 1]) - 1);
            }

            ans[index++] = map.size();
            start++;
            end++;
        }
        return ans;
    }

}
