package revision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * search in Sorted 2d matrix
 */
public class SortedMatrixSearch {

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int[] arr = A.stream().flatMapToInt(x -> x.stream().mapToInt(Integer::intValue)).sorted().toArray();
        //can apply BS on the above
        return binarySearch(arr, B);

    }

    private int binarySearch(int[] arr, int k) {

        int mid = -1;
        int high = arr.length;
        int low = 0;
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
}
