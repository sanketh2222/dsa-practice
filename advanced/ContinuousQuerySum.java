

import java.util.Arrays;

public class ContinuousQuerySum {

    public static int[] solve(int A, int[][] B) {
        int[] ans = new int[A];
        for (int[] donationEntry : B) {
            int start = donationEntry[0];
            int end = donationEntry[1];
            int val = donationEntry[2];

            ans[start - 1] += val;
            if ((end - 1) < A - 1)
                ans[end] -= val;
        }
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i];
            ans[i] = sum;

        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] mat = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int[] ans = ContinuousQuerySum.solve(A, mat);
        Arrays.stream(ans).forEach(System.out::print);

    }
}
