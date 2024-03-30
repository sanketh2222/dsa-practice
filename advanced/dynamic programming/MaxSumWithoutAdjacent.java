

public class MaxSumWithoutAdjacent {

    public int adjacent(int[][] A) {
        int[] arr = new int[A[0].length];
        int[] dp = new int[A[0].length + 1];
        int colSize = A[0].length;

        int i = 0, j = 0;
        while (j < colSize) {
            arr[i++] = Math.max(A[0][j], A[1][j]);
            j++;
        }
        dp[0] = arr[0];
        if (arr.length == 1)
            return dp[0];

        dp[1] = Math.max(arr[0], arr[1]);

        for (int x = 2; x < arr.length; x++) {
            dp[x] = Math.max(arr[x] + dp[x - 2], dp[x - 1]);
        }

        return dp[colSize - 1];
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjacent maxSumWithoutAdjacent = new MaxSumWithoutAdjacent();
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 2, 3, 4, 5 }
        };
        System.out.println(maxSumWithoutAdjacent.adjacent(mat));

    }
}
