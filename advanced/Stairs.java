

import java.util.regex.Pattern;

public class Stairs {
    public int climbStairs(int A) {

        if (A <= 1)
            return 1;

        long a = 1, b = 2;
        long ans = 2;
        int mod = 1000000007;

        for (int i = 3; i <= A; i++) {
            ans = (a % mod + b % mod) % mod;
            a = b;
            b = ans;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        // System.out.println(stairs.climbStairs(55007));
        String udyamNo = "UDYAM-DL-08-0013568";
        String udyogNo = "AS03F0005102";
        System.out.println(Pattern.matches("UDYAM-[A-Za-z]{2}-[0-9]{2}-[0-9]{7}$", udyamNo.trim()));
        System.out.println(Pattern.matches("^[A-Za-z]{2}[0-9]{2}[a-zA-Z]{1}[0-9]{7}$", udyogNo.trim()));

    }
}
