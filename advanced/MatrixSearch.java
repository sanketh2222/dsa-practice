package advanced;

public class MatrixSearch {

    public int solve(int[][] A, int B) {
        for (int i = 0; i < A.length; i++) {
            int index = search(A[i], B);// j -> index
            if (index != -1)
                return ((i + 1) * 1009 + index + 1);
        }

        return -1;
    }

    private int search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == k)
                return mid;
            else if (arr[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;

            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        MatrixSearch matrixSearch = new MatrixSearch();
        int[][] mat = { { 3, 3, 3 }, { 3, 3, 3 }, { 3, 3, 3 } };
        int ans = matrixSearch.solve(mat, 3);
        System.out.println(ans);

    }
}
