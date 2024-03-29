public class TwoMissingNumbersFinder {

    // Question: https://www.interviewbit.com/problems/missing-two-numbers/
    // Given an array of integers from 1 to n with two numbers missing, find the
    // missing numbers.
    // Leetcode: https://leetcode.com/problems/missing-two-numbers/
    // check bit manipulation 1 notes last question for explanation
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        int n = arr.length + 2;
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // Find the rightmost set bit
        int setBit = 0;
        for (int i = 0; i <= 31; i++) {
            if (checkBit(xor, i)) {
                setBit = i;
                break;
            }
        }

        int x = 0;
        int y = 0;

        // Divide the numbers into two groups based on the set bit
        for (int i = 0; i < arr.length; i++) {
            if (checkBit(arr[i], setBit)) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }

        // Divide the numbers from 1 to n into two groups based on the set bit
        for (int i = 1; i <= n; i++) {
            if (checkBit(i, setBit)) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        System.out.println(x + " " + y);
    }

    // checkbit
    private static boolean checkBit(int n, int pos) {
        int val = n & (1 << pos);
        if (val == 0)
            return false;
        return true;
    }
}
