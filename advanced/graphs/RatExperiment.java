public class RatExperiment {

    public static int solve(int[][] A, int[] B) {
        int n = B.length;
        int[] isVaccinated = new int[n + 1];

        int minCost = 0;
        for (int i = 0; i < A.length; i++) {
            if (isVaccinated[A[i][0]] == 0 && isVaccinated[A[i][1]] == 0) {
                minCost += Math.min(B[(A[i][0] - 1)], B[(A[i][1] - 1)]);
                isVaccinated[A[i][0]] = 1;
                isVaccinated[A[i][1]] = 1;
            } else {
                isVaccinated[A[i][0]] = 1;
                isVaccinated[A[i][1]] = 1;
            }
        }

        for (int i = 1; i < isVaccinated.length; i++) {
            if (isVaccinated[i] == 0) {
                minCost += B[i - 1];
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        // int[][] A = {
        // { 1, 2 }
        // };
        // int[][] A = {
        // { 1, 2 },
        // { 2, 3 },
        // { 3, 1 }
        // };
        int[][] A = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 },
                { 7, 8 },
                { 9, 10 }
        };

        // int[] B = { 2, 4, 3 };
        // int[] B = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] B = { 1, 6, 2, 7, 3, 8, 4, 9, 5, 10 };
        System.out.println(solve(A, B));

    }
}
