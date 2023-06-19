import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

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

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (A[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair curr = queue.poll();
                for (int[] dir : directions) {
                    freshOranges = getFreshOranges(A, queue, time, freshOranges, minutes, curr, dir);
                }
            }
            minutes++;// calculate the level
        }

        if (freshOranges > 0) {
            return -1;
        }
        return minutes - 1;
    }

    private int getFreshOranges(int[][] A, Queue<Pair> queue, int[][] time, int freshOranges, int minutes, Pair curr,
            int[] dir) {
        int nextI = curr.first + dir[0];
        int nextJ = curr.second + dir[1];
        if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length
                && A[nextI][nextJ] == 1) {
            A[nextI][nextJ] = 2;
            queue.offer(new Pair(nextI, nextJ));
            freshOranges--;
            time[nextI][nextJ] = minutes + 1;
        }
        return freshOranges;
    }

    public static void main(String[] args) {
        RottenOrange rottenOrange = new RottenOrange();
        int[][] mat = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(rottenOrange.solve(mat));

    }
}
