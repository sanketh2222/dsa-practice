
import java.util.Arrays;

public class MinXorValue {

    // intuition: sort the array and find the minimum xor value between adjacent
    // elements
    // the minimum xor value will be between adjacent elements in the sorted array
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            ans = Math.min(ans, A[i] ^ A[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 4, 6, 2 };
        MinXorValue minXorValue = new MinXorValue();
        int ans = minXorValue.findMinXor(arr);
        System.out.println(ans);

    }
}
