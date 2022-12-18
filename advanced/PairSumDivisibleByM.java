package advanced;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByM {

    public static int solve(int[] A, int B) {
        long ans = 0;
        int m = 1000000007;
        Map<Integer, Long> hashmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int modValue = A[i] % B;
            if (hashmap.containsKey(modValue)) {
                long freq = hashmap.get(modValue);
                hashmap.put(modValue, ++freq);
            } else {
                hashmap.put(modValue, 1L);
            }
        }

        int i = 1, j = B - 1;
        if (hashmap.containsKey(0))
            ans += ((hashmap.get(0) * (hashmap.get(0) - 1)) / 2) % m;

        while (i < j) {
            if (hashmap.containsKey(i) && hashmap.containsKey(j))
                ans += (hashmap.get(i) * hashmap.get(j));
            i++;
            j--;
        }

        if (B % 2 == 0 && hashmap.containsKey(B / 2)) {
            ans += ((hashmap.get(B / 2) * (hashmap.get(B / 2) - 1)) / 2) % m;
        }

        return (int) ans % m;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 17, 100, 11 };
        int ans = PairSumDivisibleByM.solve(arr, 28);
        System.out.println(ans);

    }
}
