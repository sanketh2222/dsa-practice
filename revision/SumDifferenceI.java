package revision;

import java.util.Arrays;
import java.util.Comparator;

public class SumDifferenceI {

    public int solve(int[] A) {
        int mod = 1000000007;
        long maxSum = 0;
        long minSum = 0;
        int N = A.length;
        // int ans = 0;
        // Sort the array
        Arrays.sort(A);
        // Summation of smallest numbers over all subsequences
        // for (int i = 0; i < N; i++) {
        // minSum = (minSum * 2) % mod;
        // minSum = (minSum + A[i]) % mod;
        // }
        // // Summation of largest numbers over all subsequences
        // for (int i = N - 1; i >= 0; i--) {
        // maxSum = (maxSum * 2) % mod;
        // maxSum = (maxSum + A[i]) % mod;
        // }
        int n = A.length;
        for (int i = 0; i < n; i++) {
            maxSum += (A[i] * pow(2, i, mod)) % mod;

            minSum += (A[i] * pow(2, n - i - 1, mod)) % mod;
        }
        long ans = (maxSum - minSum + mod) % mod;
        return (int) ans;
    }

    public long pow(long A, int B, int C) {
        if (B == 0 && C != 0)
            return (1 % C);
        if (B == 0)
            return 1;

        long halfPower = pow(A, B / 2, C);

        // Below can be a pull answer if B is even, in case of odd power
        // it can be considered as partial answer which needs to be multipled by A
        int halfAns = (int) ((long) (halfPower % C) * halfPower % C) % C;

        if (B % 2 == 0) {
            return halfAns;
        }
        if (A < 0)
            return (A % C) * (halfAns % C) + C;

        return (int) ((long) (A % C) * halfAns % C);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 10 };
        SumDifferenceI differenceI = new SumDifferenceI();
        // int[] arr = { 1, 2, 3, 4, 5 };

        // Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(differenceI.solve(arr));
    }
}
