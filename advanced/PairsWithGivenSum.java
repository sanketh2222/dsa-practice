

public class PairsWithGivenSum {

    public int solve(int[] A, int B) {
        int i = 0, j = A.length - 1;
        int ans = 0;
        int a = 1, b = 1;
        int mod = 1000000007;

        while (i < j) {
            int sum = mod_add(A[i], A[j]);

            if (sum == B) {
                a = 1;
                b = 1;

                if (A[i] == A[j]) {
                    int x = (j - i + 1);
                    ans += ((x) % mod * (x - 1) % mod) % mod / 2;
                    break;
                }

                while ((i < A.length - 1) && A[i] == A[i + 1]) {
                    i += 1;
                    a += 1;
                }

                while (j >= 1 && (A[j] == A[j - 1])) {
                    j -= 1;
                    b += 1;
                }

                ans += (a % mod * b % mod) % mod;

                i++;
                j--;

            } else if (sum > B) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }

    private int mod_add(int a, int b) {
        int mod = 1000000007;
        a = a % mod;
        b = b % mod;
        int res = ((a + b) % mod + mod) % mod;
        return res;
    }


    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10 };
        PairsWithGivenSum givenSum = new PairsWithGivenSum();
        int ans = givenSum.solve(arr, 11);
        System.out.println(ans);
    }
}
