import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInMaze {

    class Tupple {
        int row;
        int col;
        int dist;

        public Tupple(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

    }

    // mat , source , dest
    public int solve(int[][] A, int[] B, int[] C) {
        int rowSize = A.length;
        int colSize = A[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];

        int[][] dist = new int[rowSize][colSize];

        Queue<Tupple> queue = new PriorityQueue<>((x, y) -> (x.dist - y.dist));

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // mark source to source dist as 0
        visited[B[0]][B[1]] = true;
        queue.offer(new Tupple(B[0], B[1], 0));

        int[] x = { 1, 0, -1, 0 };
        int[] y = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            Tupple t = queue.poll();

            int r = t.row;
            int c = t.col;
            int d = t.dist;

            if (dist[r][c] != Integer.MAX_VALUE) {
                continue;
            } else {
                dist[r][c] = d;
            }

            for (int i = 0; i < y.length; i++) {
                
                int d1 = 0;
                r = t.row;
                c = t.col;

                while ((r >= 0 && r < rowSize) &&
                        (c >= 0 && c < colSize) && (A[r][c] == 0)) {
                    r += x[i];
                    c += y[i];
                    d1 += 1;
                }

                r -= x[i];
                c -= y[i];
                d1 -= 1;

                if (d1 > 0 && dist[r][c] == Integer.MAX_VALUE) {
                    queue.offer(new Tupple(r, c, d + d1));
                }
            }
        }
        if (dist[C[0]][C[1]] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[C[0]][C[1]];
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 0, 0, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 0 }

        };
        int[] B = { 3, 4 };
        int[] C = { 1, 3 };
        ShortestPathInMaze pathInMaze = new ShortestPathInMaze();
        System.out.println(pathInMaze.solve(A, B, C)); // 3
    }
}
