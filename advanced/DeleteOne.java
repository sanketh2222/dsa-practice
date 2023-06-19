

public class DeleteOne {

    public int solve(int[] A) {
        // Build prefix
        int[] prefix = new int[A.length];
        int[] suffix = new int[A.length];
        int gcd = 0;
        for (int i = 0; i < A.length; i++) {
            gcd = gcd(gcd, A[i]);
            prefix[i] = gcd;
        }
        gcd = 0;

        // Build suffix
        for (int i = A.length - 1; i >= 0; i--) {
            gcd = gcd(gcd, A[i]);
            suffix[i] = gcd;
        }

        int gcd1 = 0, gcd2 = 0, ans = 0;
        gcd = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                gcd1 = suffix[i + 1];
            } else if (i == A.length - 1) {
                gcd1 = prefix[i - 1];
            } else {
                gcd1 = prefix[i - 1];
                gcd2 = suffix[i + 1];
            }
            gcd = gcd(gcd1, gcd2);
            ans = Math.max(ans, gcd);

        }

        return ans;
    }

    private int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }

    public static void main(String[] args) {
        DeleteOne deleteOne = new DeleteOne();
        int[] arr = { 12, 15, 18 };
        deleteOne.solve(arr);

    }
}
