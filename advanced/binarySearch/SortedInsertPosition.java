package binarySearch;


public class SortedInsertPosition {

    public int searchInsert(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;

            if (A[mid] == B){
                return mid;
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (A[mid] > B)
            return mid;

        return mid + 1;
    }

    public static void main(String[] args) {
        SortedInsertPosition insertPosition = new SortedInsertPosition();
        int[] arr = {1, 3, 5, 6};
        System.out.println(insertPosition.searchInsert(arr, 7));

    }
}
