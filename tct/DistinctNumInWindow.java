import java.util.HashMap;
import java.util.Map;

public class DistinctNumInWindow {
    public int[] dNums(int[] A, int B) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = A.length;
        int[] ans = new int[n - B + 1];
        for (int i = 0; i < B; i++) {
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
        }

        int start = 1, end = B;
        ans[0] = mp.size();

        while (end < n) {
            mp.put(A[start - 1], mp.get(A[start - 1]) - 1);

            if (mp.get(A[start - 1]) == 0) {
                mp.remove(A[start - 1]);
            }

            mp.put(A[end], mp.getOrDefault(A[end], 0) + 1);
            ans[start] = mp.size();
            start++;
            end++;
        }

        return ans;
    }
}
