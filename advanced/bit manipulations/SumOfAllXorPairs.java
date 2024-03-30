public class SumOfAllXorPairs {

    // leetcode link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/
    // Time complexity: O(n)
    // Space complexity: O(1)
    // refer to bit manipulation 2 notes Q2 for explanation
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (checkBit(A[j], i)) {
                    count++;
                }
            }
            ans += (count * (n - count) * (1 << i));
        }
        return ans;
    }

    // check bit
    public static boolean checkBit(int n, int i) {
        return (n & (1 << i)) == 0 ? false : true;
    }

    public static void main(String[] args) {
        SumOfAllXorPairs xorPairs = new SumOfAllXorPairs();
        int[] arr = { 1, 2, 3 };
        System.out.println(xorPairs.solve(arr));
    }
}
