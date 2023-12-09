package arrays;

import java.util.*;

public class MissingNumber {

    // https://leetcode.com/problems/missing-number/description/
    // Given an array nums containing n distinct numbers in the range [0, n], return
    // the only number in the range that is missing from the array.

    public int missingNumber(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                int pos = nums[i] - 1;
                if (nums[pos] != nums[i]) {
                    int temp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = temp;
                    i--; // the number which got swapped to cuurent position might not be at the correct
                         // index

                }

            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Collections.swap(names, 0, 2);
        Collections.swap(names, 2, 0);
        //the above 2 lines provide same result

        System.out.println(names);
    }
}
