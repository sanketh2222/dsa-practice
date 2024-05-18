import java.util.ArrayList;
import java.util.List;

public class XorBag {
    //Pick from both sides
    //TC: O(n) SC: O(n)
    //https://www.scaler.com/test/50a55aed26/#/problem_5
    public int solve(int[] A) {
        List<Integer> redBag = new ArrayList<>();
        List<Integer> blueBag = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            int minEle = Math.min(A[i], A[n - i - 1]);
            int maxEle = Math.max(A[i], A[n - i - 1]);

            redBag.add(maxEle);
            blueBag.add(minEle);
        }

        int xorSum = 0;
        n = n / 2;
        for (int i = 0; i < n; i++) {
            xorSum += ((redBag.get(i)) ^ (blueBag.get(n - i - 1)));
        }

        return xorSum;
    }
}
