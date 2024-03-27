package matrix;


public class SumOfAllSubMatrix {

    public long solve(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        long subMatrixSum = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (rowSize - i) * (colSize - j);
                subMatrixSum += (topLeft * bottomRight * A[i][j]);
            }
        }

        return subMatrixSum;
    }

    public static void main(String[] args) {
        SumOfAllSubMatrix maximumSubmatrixSum = new SumOfAllSubMatrix();
        int[][] matrix = { { -5, -4, -3 }, { -1, 2, 3 }, { 2, 2, 4 } };
        long ans = maximumSubmatrixSum.solve(matrix);
        System.out.println(ans);
    }
}
