package matrix;

public class SpiralMatrix {

    public int[][] generateMatrix(int A) {
        int[][] spiralMat = new int[A][A];
        int counter = 1;
        int n = A;
        int i = 0;
        int j = 0;

        while (n > 1) {

            for (int k = 1; k < n; k++) {
                spiralMat[i][j] = counter++;
                j += 1;
            }

            for (int k = 1; k < n; k++) {
                spiralMat[i][j] = counter++;
                i += 1;
            }

            for (int k = 1; k < n; k++) {
                spiralMat[i][j] = counter++;
                j -= 1;
            }

            for (int k = 1; k < n; k++) {
                spiralMat[i][j] = counter++;
                i -= 1;
            }
            j += 1;
            i += 1;
            n -= 2;
        }

        if (n == 1) {
            spiralMat[i][j] = counter;
        }

        return spiralMat;
    }

    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        matrix.generateMatrix(5);
    }
}
