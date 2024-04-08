public class MaximumAndPairFinder {

    //intuition: we need to find the maximum number that can be formed by taking AND of two numbers in the array
    //we can do this by checking the bits from MSB to LSB
    //if we can make a pair for a bit, we set that bit in the answer
    //to make a pair for a bit, we need to have atleast 2 numbers with that bit set
    //if we have atleast 2 numbers with that bit set, we set that bit in the answer
    public static int findMaximumAndPair(int[] nums) {
        int ans = 0;

        // Iterate through each bit position from MSB to LSB
        for (int i = 31; i >= 0; i--) {
            int setBitCount = 0; // Count the number of set bits at ith index

            // Count the number of elements with the bit set at ith index
            for (int num : nums) {
                if (checkBit(num, i)) {// check if the ith bit is set
                    setBitCount++;
                }
            }

            // If count is greater than or equal to 2, set the bit in the answer
            if (setBitCount >= 2) { // can make a pair for this bit for AND operation
                ans |= (1 << i); // Set the bit at ith index in the answer

                // Set all numbers which have 0 bit at this position to 0
                for (int j = 0; j < nums.length; j++) {
                    if (!checkBit(nums[j], i)) { // check if the ith bit is not set
                        nums[j] = 0;
                    }
                }
            }
        }

        return ans;
    }

    // checkbit
    private static boolean checkBit(int n, int pos) {
        int val = n & (1 << pos);
        if (val == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, 8, 3, 8, 2, 6 };
        int maxAndPair = findMaximumAndPair(nums);
        System.out.println("Maximum AND pair: " + maxAndPair);
    }
}
