public class SpecialIndex {

    public int solve(int[] A) {
        int sumEven = 0, sumOdd = 0;
        int[] prefixEven = new int[A.length];
        int[] prefixOdd = new int[A.length];

        // Prefix sum of even and odd indexed elements
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0)// skip contribution of odd indexes
                sumEven += A[i];
            prefixEven[i] = sumEven; // skip contribution of odd indexes
        }

        // Prefix sum of odd indexed elements
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 1)// skip contribution of even indexes
                sumOdd += A[i];

            prefixOdd[i] = sumOdd;// skip contribution of even indexes
        }

        sumEven = 0;
        sumOdd = 0;
        int n = A.length - 1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                sumEven = prefixOdd[n] - prefixOdd[i];
                sumOdd = prefixEven[n] - prefixEven[i];
            } else {
                sumEven = prefixEven[i - 1] + (prefixOdd[n] - prefixOdd[i]);
                sumOdd = prefixOdd[i - 1] + (prefixEven[n] - prefixEven[i]);
            }
            if (sumEven == sumOdd)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        SpecialIndex index = new SpecialIndex();
        int a = index.solve(new int[] { 1, 2, 3, 7, 1, 2, 3 });
        System.out.println(a);

    }
}
