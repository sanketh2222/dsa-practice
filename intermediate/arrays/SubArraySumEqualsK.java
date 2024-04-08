import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    //longest subarray with sum equal to k
    public static int solve(int[] A, int B) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (hashMap.containsKey(sum - B)) {
                count += 1;
            } else {
                hashMap.put(sum, i);
            }
        }
        return count;
    }

    // 2 POINTER APPROACH

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2 };
        int ans = SubArraySumEqualsK.solve(arr, 3);
        System.out.println(ans);

    }
}
