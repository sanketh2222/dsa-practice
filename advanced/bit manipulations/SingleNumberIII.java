
import java.math.BigInteger;

public class SingleNumberIII {

    // We are given an integer array where every number occurs twice except for one
    // number which occurs just once. Find that number.
    // Question: https://www.interviewbit.com/problems/single-number-iii/
    // Leetcode: https://leetcode.com/problems/single-number-iii/
    public int[] singleNumber(final int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        int setBit = 0;
        for (int i = 0; i <= 31; i++) {
            if (checkBit(xor, i)) {
                setBit = i;
                break;
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < A.length; i++) {
            if (checkBit(A[i], setBit)) {
                ans[0] ^= A[i];
            } else {
                ans[1] ^= A[i];
            }
        }
        return ans;
    }

    private boolean checkBit(int n, int pos) {
        int val = n & (1 << pos);
        if (val == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        long val = 2;
        long ans = (val << 31);
        System.out.println(val);
        long ans2 = (val << 30);

        BigInteger ans3 = new BigInteger("2147483648");
        BigInteger ans4 = new BigInteger("6442450944");
        BigInteger aInteger = ans3.add(ans4);
        System.out.println(aInteger);
        String str = "11000000000000000000000000000000";
        // System.out.println(str.length());
        System.out.println(ans + ans2);
        int a = 3;
        int b = 30;
        String aa = String.valueOf(a) + String.valueOf(b);
        String bb = String.valueOf(b) + String.valueOf(a);
        System.out.println(aa.compareTo(bb));
        System.out.println(bb.compareTo(aa));

    }
}
