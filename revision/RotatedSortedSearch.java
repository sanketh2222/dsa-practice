package revision;

public class RotatedSortedSearch {

    public int search(final int[] A, int B) {
        int pivot = findPivot(A);
        int ans = 0;
        if (pivot == -1) {
            ans = binarySearch(A, B, 0, A.length - 1);
        } else if (B >= A[0]) {
            // first half
            ans = binarySearch(A, B, 0, pivot - 1);
        } else {
            // 2nd half
            ans = binarySearch(A, B, pivot, A.length - 1);
        }

        return ans;

    }

    private int binarySearch(int[] arr, int k, int low, int high) {

        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                // move right
                low = mid + 1;
            } else {
                // move left
                high = mid - 1;
            }
        }

        return  -1;
    }

    private int findPivot(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        int pivot = -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (arr[mid] >= arr[0]) {
                l = mid + 1; // move right side
            } else {
                pivot = mid;
                h = mid - 1;// move left side
            }
        }

        return pivot;
    }

    public static void main(String[] args) {
        int[] arr = {19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17 };
        RotatedSortedSearch rotatedSortedSearch = new RotatedSortedSearch();
        System.out.println(rotatedSortedSearch.search(arr, 202));
    }
}
