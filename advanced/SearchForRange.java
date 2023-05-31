

public class SearchForRange {

    public int[] searchRange(final int[] A, int B) {
        int[] ans = { -1, -1 };
        int firstOcc = findFirstOccurence(A, A.length, B);
        int lastOcc = findLastOccurence(A, A.length, B);

        ans[0] = firstOcc;
        ans[1] = lastOcc;

        return ans;

    }

    private int findFirstOccurence(int[] arr, int n, int k) {
        int low = 0, high = n - 1, ans = -1;
        while ((low <= high)) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                ans = mid;
                high = mid - 1; // move left to find first occ
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    private int findLastOccurence(int[] arr, int n, int k) {
        int low = 0, high = n - 1, ans = -1;
        while ((low <= high)) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                ans = mid;
                low = mid + 1;// right side
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        SearchForRange forRange = new SearchForRange();
        int[] arr = { 5, 17, 100, 111 };
        int B = 8;
        int[] ans = forRange.searchRange(arr, B);
        System.out.println(ans[0] + " " + ans[1]);

    }
}
