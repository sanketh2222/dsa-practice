package binarySearch;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;

        } else if (nums[n - 1] > nums[n - 2]) {
            return n - 1;

        }

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // peak element condition
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;

            } else if (nums[mid - 1] > nums[mid]) {
                // peak lies in the left side(better chances of finding the peak element in the
                // left half since left side element is greater than mid)
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
}
