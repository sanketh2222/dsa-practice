import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int solve(int[][] A) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] time = new int[A.length][A[0].length];
        int freshOranges = 0;
        int currTime = 0;// totalLevels

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (A[i][j] == 1) {
                    freshOranges += 1;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] x = { -1, 1, 0, 0 };
                int[] y = { 0, 0, -1, 1 };
                Pair pair = queue.poll();
                for (int k = 0; k < y.length; k++) {
                    freshOranges = bfs(pair.first + x[k], pair.second + y[k], A, time, queue, currTime, freshOranges);
                }
            }
            // keep track of level
            currTime += 1;
            // bfs(pair.first, pair.second, A, time, queue, time[pair.first][pair.second]);
        }

        if (freshOranges > 0)
            return -1;

        return currTime - 1;
    }

    private int bfs(int i, int j, int[][] mat, int[][] time, Queue<Pair> queue, int currTime, int freshOranges) {
        if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && mat[i][j] == 1) {
            mat[i][j] = 2;
            freshOranges -= 1;
            time[i][j] = currTime + 1;
            queue.offer(new Pair(i, j));
        }
        return freshOranges;

    }

    //Wrong
    private void bfs1(int i, int j, int[][] mat, int[][] time, Queue<Pair> queue,
            int currTime) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }

        if (mat[i][j] != 2) {
            time[i][j] = currTime + 1;
            mat[i][j] = 2;
            queue.offer(new Pair(i, j));
        } else {
            mat[i][j] = 0;
        }

        bfs(i - 1, j, mat, time, queue, time[i][j]);
        bfs(i + 1, j, mat, time, queue, time[i][j]);
        bfs(i, j - 1, mat, time, queue, time[i][j]);
        bfs(i, j + 1, mat, time, queue, time[i][j]);
    }

    private void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        int[][] mat1 = {
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 2, 0, 1, 0 },
                { 0, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 }
        };
        RottenOranges oranges = new RottenOranges();
        System.out.println(oranges.solve(mat1));

    }
}
