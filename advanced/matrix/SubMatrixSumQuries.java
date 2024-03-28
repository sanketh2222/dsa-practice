package matrix;

import java.util.ArrayList;

public class SubMatrixSumQuries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int mod = 1000000007;
        int[][] ps = new int[rowSize][colSize];
        long sum = 0;

        ArrayList<Integer> ansLst = new ArrayList<>();

        // rowwise ps
        for (int i = 0; i < rowSize; i++) {
            sum = 0;
            for (int j = 0; j < colSize; j++) {
                sum = ((sum % mod) + (A[i][j] % mod)) % mod;
                ps[i][j] = (int) sum;
            }
        }

        // col wise ps
        sum = 0;
        for (int i = 0; i < colSize; i++) {
            sum = 0;
            for (int j = 0; j < rowSize; j++) {
                sum = ((sum % mod) + (ps[j][i] % mod)) % mod;
                ps[j][i] = (int) sum;

            }
        }

        // Query 1
        for (int i = 0; i < B.length; i++) {
            int topLeftRowIndex = B[i] - 1;// a1
            int topLeftColIndex = C[i] - 1;// b1

            int bottomRightRowIndex = D[i] - 1;// a2
            int bottomRightColIndex = E[i] - 1;// b2

            int fisrtMaxSum = (int) getSum(ps, topLeftRowIndex, topLeftColIndex,
                    bottomRightRowIndex, bottomRightColIndex);

            ansLst.add(fisrtMaxSum);
        }

        return ansLst.stream().mapToInt(x -> x).toArray();
    }

    // a1 b1 a2 b2
    private long getSum(int[][] ps, int topLeftRowIndex, int topLeftColIndex, int bottomRightRowIndex,
            int bottomRightColIndex) {
        long sum;
        int mod = 1000000007;
        sum = ps[bottomRightRowIndex][bottomRightColIndex];
        if (topLeftColIndex > 0)
            sum -= (ps[bottomRightRowIndex][topLeftColIndex - 1] % mod);

        if (topLeftRowIndex > 0)
            sum -= (ps[topLeftRowIndex - 1][bottomRightColIndex] % mod);

        if (topLeftRowIndex > 0 && topLeftColIndex > 0)
            sum += (ps[topLeftRowIndex - 1][topLeftColIndex - 1] % mod);

        return ((sum % mod) + mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(-60 % 9);
        System.out.println(((-60 % 9) + 9) % 9);
    }
}