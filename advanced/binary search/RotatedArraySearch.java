

public class RotatedArraySearch {

    public int search(final int[] A, int B) {
        int ans = 0;
        int pivot = findPivot(A);
        if (pivot == -1) {
            ans = binnarySearch(A, B, 0, A.length - 1);

        } else if (A[0] <= B) {
            ans = binnarySearch(A, B, 0, pivot - 1);

        } else {
            ans = binnarySearch(A, B, pivot, A.length - 1);
        }
        return ans;
    }

    private int binnarySearch(int[] arr, int k, int start, int end) {
        int low = start, high = end;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] A) {
        int pivot = -1;
        int low = 0, high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] >= A[0]) {
                // move right
                low = mid + 1;

            } else {// move left
                pivot = mid;
                high = mid - 1;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3 };// 5, 1, 3
        RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();
        int ans = rotatedArraySearch.search(arr, 5);
        // int k = rotatedArraySearch.binnarySearch(arr, 7, 0, 3);
        System.out.println(ans);
    }
}
