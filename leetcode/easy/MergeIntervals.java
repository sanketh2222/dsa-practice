package easy;

import java.util.*;

public class MergeIntervals {

    // Given an array of intervals where intervals[i] = [starti, endi], merge all
    // overlapping intervals, and return an array of the non-overlapping intervals
    // that cover all the intervals in the input.

    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            // If the current interval overlaps with the next interval
            if (currentInterval[1] >= interval[0]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Add the merged interval to the result and update currentInterval
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last merged interval
        mergedIntervals.add(currentInterval);

        // Convert List<int[]> to int[][]
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }

    // if ? is not added then it will give compilation error
    public List<? extends List<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = { { 0, 2 }, { 1, 4 }, { 5, 6 }, { 6, 8 } };
        int[][] merged = mergeIntervals.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
