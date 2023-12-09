package matrix;

public class RotateMatrix {

    public void solve(int[][] A) {
        int n = A[0].length;
        transpose(A);
        // for (int i = 0; i < n; i++) {
        // reverseArr(A[i]);
        // }

    }

    private void transpose(int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }

    }

    private void reverseArr(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i > j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        new RotateMatrix().solve(mat);
    }
}
