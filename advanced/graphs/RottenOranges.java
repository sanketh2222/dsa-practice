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
                int[] dx = { -1, 1, 0, 0 };
                int[] dy = { 0, 0, -1, 1 };
                Pair pair = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int x = pair.first + dx[k];
                    int y = pair.second + dy[k];
                    freshOranges -= bfs(x, y, A, queue);
                }
            }
            // keep track of level
            currTime += 1;
        }

        if (freshOranges > 0)
            return -1;

        return currTime - 1;
    }

    private int bfs(int i, int j, int[][] mat, Queue<Pair> queue) {
        int rottenOranges = 0;
        if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && mat[i][j] == 1) {
            mat[i][j] = 2;
            rottenOranges += 1;
            queue.offer(new Pair(i, j));
        }

        return rottenOranges;

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
