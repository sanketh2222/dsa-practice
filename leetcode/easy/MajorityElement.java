package easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // there can be only 1 major element
        int me = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (me != nums[i]) {
                cnt -= 1;
                if (cnt == 0) {
                    me = nums[i];
                    cnt = 1;
                }
            } else {
                cnt += 1;
            }
        }

        cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == me) {
                cnt += 1;
            }
        }

        return cnt >= (nums.length / 2) ? me : -1;

    }

    private boolean checkBit(int n, int pos) {
        // return n & (1 << pos); // return an integer (1 or 0)
        return (n & (1 << pos)) != 0;
    }
}
