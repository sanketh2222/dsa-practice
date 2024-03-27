package matrix;


public class MaxSubMatrixSum {

    public long solve(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        long ans = Integer.MIN_VALUE;
        for (int startRow = 0; startRow < rowSize; startRow++) {
            long[] arr = new long[colSize];
            for (int endRow = startRow; endRow < rowSize; endRow++) {
                for (int j = 0; j < colSize; j++) {
                    arr[j] += A[endRow][j];
                }

                ans = Math.max(ans, maxSubArray(arr));
            }
        }

        return ans;
    }

    //kadane's algorithm
    private int maxSubArray(long[] A) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            ans = Math.max(ans, sum);

            if (sum < 0)
                sum = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = new int[5];
        // Arrays.stream(arr).forEach(System.out::println);
        MaxSubMatrixSum matrixSum = new MaxSubMatrixSum();
        int[][] mat = { { -58, -51 }, { -5, 14 }, { 32, 45 }, { 45, 89 } };
        long ans = matrixSum.solve(mat);
        System.out.println(ans);

    }
}
