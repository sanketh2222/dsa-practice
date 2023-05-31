

import java.util.Arrays;

public class KnapSack {

    // A -> Values B -> wtrs
    public int solve(int[] A, int[] B, int C) {
        int[][] ks = new int[A.length + 1][C + 1];
        for (int[] row : ks) {
            Arrays.fill(row, -1);
        }
        return ks(A, B, ks, A.length - 1, C);
    }

    private int ks(int[] v, int[] w, int[][] ks, int i, int j) {

        if (i == -1 || j == -1)
            return 0;

        if (ks[i][j] == -1) {
            // didnt pick
            int a = ks(v, w, ks, i - 1, j);
            if (w[i] <= j)
                a = Math.max(a, ks(v, w, ks, i - 1, j - w[i]) + v[i]);
            ks[i][j] = a;
        }

        return ks[i][j];
    }

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        int[] A = { 60, 100, 120 };
        int[] B = { 10, 20, 30 };

        System.out.println(knapSack.solve(A, B, 50));
    }
}
