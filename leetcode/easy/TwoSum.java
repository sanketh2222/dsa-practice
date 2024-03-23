package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hs = new HashMap<>();
        int[] ans = new int[2];
        int k = target;
        hs.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (hs.containsKey(k - nums[i])) {
                ans[0] = hs.get(k - nums[i]);
                ans[1] = i;
            } else {
                hs.put(nums[i], i);
            }
        }

        return ans;
    }
}