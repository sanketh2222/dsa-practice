

public class NoOfIsnald {

    public int solve(int[][] A) {
        int noOfIsland = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    noOfIsland += 1;
                }
            }
        }
        return noOfIsland;
    }

    private void dfs(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }

        int[] x = { 0, 0, -1, 1, -1, -1, 1, 1 };
        int[] y = { -1, 1, 0, 0, -1, 1, -1, 1 };

        mat[i][j] = 0;
        for (int k = 0; k < x.length; k++) {
            dfs(mat, i + x[k], j + y[k]);
        }
    }

    public static void main(String[] args) {
        NoOfIsnald isnald = new NoOfIsnald();
        int[][] mat = {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        System.out.println(isnald.solve(mat));

    }
}
