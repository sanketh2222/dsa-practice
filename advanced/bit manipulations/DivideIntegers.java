

public class DivideIntegers {

    public int divide(int A, int B) {
        int ans = 0;
        if (A >= 0 && B >= 0)
            return (A >> (B - 1));
        else if (A < 0 && B < 0)
            ans = Math.abs((A >> (B + 1))) == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs((A >> (B + 1)));// here
        else if ((A < 0 && B > 0))
            ans = -Math.abs((A >> (B - 1)));// here
        else if ((A > 0 && B < 0))
            ans = Math.abs((A >> (B + 1)));
        else
            ans = Math.abs((A >> (B + 1)));

        // return ans == Integer.MIN_VALUE ? Integer.MAX_VALUE : ans;
        return ans;
    }

    //divide integers using bit manipulation
    public int divideIntegers(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        DivideIntegers divideIntegers = new DivideIntegers();
        // int ans = divideIntegers.divide(-2147483648, -10000000);
         
        System.out.println(2147483648l >> (10000000 - 100) );
        // System.out.println(ans);
        boolean[] b = new boolean[3];
        System.out.println(b);
    }
}
