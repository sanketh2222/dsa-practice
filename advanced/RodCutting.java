

public class RodCutting {

    public int solve(int[] A) {
        int maxCost = 0;
        int n = A.length;
        for (int i = 1; i <= n; i++) {
            int cutSize = n / i;
            int ans = 0;
            for (int j = 0; j < cutSize; j++) {
                ans += A[i - 1];
            }

            if ((n % cutSize) > 0) {
                ans += A[(n % cutSize) - 1];
            }

            maxCost = Math.max(ans, maxCost);
        }

        return maxCost;
    }

    public static void main(String[] args) {
        RodCutting cutting = new RodCutting();
        int[] arr = { 2, 7, 6, 3, 25, 13, 16, 2, 40, 41, 18, 2, 9, 6, 36, 75, 59, 42, 73 };
        System.out.println(cutting.solve(arr));

    }
}
