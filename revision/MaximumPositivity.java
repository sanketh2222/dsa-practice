package revision;

import java.util.Arrays;

public class MaximumPositivity {

    public int[] findMaximumNonNegativeSubarray(int[] A) {
        int n = A.length;
        int start = 0, end = 0;
        int maxStart = 0, maxEnd = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) {
                end = i;
            } else {
                if (end - start + 1 > maxEnd - maxStart + 1) {
                    maxStart = start;
                    maxEnd = end;
                }
                start = i + 1;
                end = i + 1;
            }
        }

        // Compare the length of the current subarray with the length of the maximum
        // subarray one last time
        if (end - start + 1 > maxEnd - maxStart + 1) {
            maxStart = start;
            maxEnd = end;
        }

        // Create the maximum subarray from A based on maxStart and maxEnd indices
        int[] maxSubarray = new int[maxEnd - maxStart + 1];
        for (int i = maxStart; i <= maxEnd; i++) {
            maxSubarray[i - maxStart] = A[i];
        }

        return maxSubarray;
    }

    public static void main(String[] args) {
        MaximumPositivity maximumPositivity = new MaximumPositivity();
        int[] arr = { 5, 6, -1, 7, 8 };
        Arrays.stream(maximumPositivity.findMaximumNonNegativeSubarray(arr)).forEach(
                System.out::println);
    }
}
