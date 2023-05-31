package revision;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NoOfIsland {

    public int solve(int[][] A) {
        int totalIsnalds = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {

                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    totalIsnalds += 1;
                }
            }
        }

        return totalIsnalds - 1;
    }

    private void dfs(int[][] mat, int i, int j) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }

        mat[i][j] = 0;

        int[] dx = { -1, 0, 1, 0, -1, 1 };
        int[] dy = { 0, -1, 0, 1, -1, 1 };

        for (int k = 0; k < 6; k++) {
            dfs(mat, i + dx[k], j + dy[k]);
        }

    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        NoOfIsland island = new NoOfIsland();
        System.out.println(island.solve(mat));
        BigDecimal zero = new BigDecimal("33");
        System.out.println(zero.toString());
        Map<String,Object> mp = new HashMap<>();
        mp.put("key", zero);
        System.out.println(mp.get("key").toString());
    }
}
