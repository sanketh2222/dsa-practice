package revision;

public class AdjacentSum {

    public int adjacent(int[][] A) {
        int[] arr = new int[A[0].length + 1];
        int[] dp = new int[A[0].length + 1];
        for (int i = 0; i < A[0].length; i++) {
            arr[i] = A[0][i] > A[1][i] ? A[0][i] : A[1][i];
        }

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(
                    arr[i] + dp[i - 2],
                    dp[i - 1]);
        }

        return dp[A[0].length - 1] ;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 2, 3, 4, 5 }
        };
        AdjacentSum adjacentSum = new AdjacentSum();
        System.out.println(adjacentSum.adjacent(mat));
    }
}
