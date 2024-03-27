package revision.matrix;

public class MatrixSearch {

    public int searchMatrix(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int s = 0;
        int e = n * m - 1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            int row = mid / m;
            int col = mid % m;
            if (A[row][col] == B) {
                return 1;
            } else if (A[row][col] < B) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
