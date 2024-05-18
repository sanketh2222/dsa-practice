package test;

public interface TestC {
    int a = 10;

    public void test();

}

// find square root of a number
/**
 * InnerTestC
 */
class InnerTestC {
    // find square root of a number using binary search
    // leetcode 69:- link: https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long low = 0, high = x;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

}
