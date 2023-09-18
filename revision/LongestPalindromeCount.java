package revision;

import java.util.Arrays;

public class LongestPalindromeCount {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int solve(int A) {
        int start = -1;
        int ans = 0;

        for (int i = 0; i < 32; i++) {

            if (checkBit(A, i) && start == -1) {
                start = i;

            } else if (checkBit(A, i)) {
                ans = Math.max(ans, i - start);
                start = i;
            }
        }

        return ans;
    }

    private boolean checkBit(int n, int i) {
        int val = n & (1 << i);
        return val == 0 ? false : true;
    }

    public int[] solve(int[] A, int[] B) {
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {

            int totalMoney = B[i];
            int totalBuy = 0;

            for (int j = 0; j < A.length; j++) {

                if (totalMoney - A[j] >= 0) {
                    totalBuy += 1;
                    totalMoney -= A[j];

                } else {
                    ans[i] = totalBuy;
                    break;
                }
            }
            if (totalMoney >= 0) {
                 ans[i] = totalBuy;
            }
        }

        return ans;
    }

    public int majorityElement(final int[] A) {
        int majorityElement = 0, freq = 0;
        for (int i = 0; i < A.length; i++){
            if (freq == 0){
                majorityElement = A[i];
                freq++;
                
            } else if (A[i] == majorityElement)
                    freq++;
            else
                    freq--;
            
        }
        // int count = 0;
        // for(int i = 0; i < A.length; i++){
        //     if (A[i] == majorityElement)
        //         count++;
        // }
        return majorityElement;
    }

    public static void main(String[] args) {
        LongestPalindromeCount lpc = new LongestPalindromeCount();
        // System.out.println(lpc.solve(11));
        int[] A = { 23, 36, 58, 59 };
        int[] B = { 3, 207, 62, 654, 939, 680, 760 };
        Arrays.stream(lpc.solve(A, B)).forEach(System.out::println);
    }
}
