import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteRoadConstruct {

    public enum Color {
        RED(1),
        GREEN(2);

        int value;

        Color(int value) {
            value = this.value;
        }
    }

    public int solve(int A, int[][] B) {
        List<List<Integer>> adjList = buildAdjLst(B, A);
        Queue<Integer> queue = new LinkedList<>();
        int[] bip = new int[A + 1];
        Arrays.fill(bip, -1);
        int set1 = 1;
        int set2 = 0;
        bip[1] = Color.RED.ordinal();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i);
                if (bip[v] == -1) {
                    Color color = bip[u] == Color.RED.ordinal() ? Color.GREEN : Color.RED;
                    if (color == Color.RED) {
                        set1 += 1;
                    } else {
                        set2 += 1;
                    }
                    bip[v] = color.ordinal();
                    queue.offer(v);
                }
            }
        }
        int extra = (set1 * set2) - (A - 1);

        return extra;
    }

    private List<List<Integer>> buildAdjLst(int[][] B, int A) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            List<Integer> lst = adjList.get(u);
            List<Integer> lst1 = adjList.get(v);
            lst.add(v);
            lst1.add(u);
        }
        return adjList;
    }

    public static void main(String[] args) {
        BipartiteRoadConstruct bipartiteRoadConstruct = new BipartiteRoadConstruct();
        int A = 5;
        int[][] B = {
                { 1, 3 },
                { 1, 4 },
                { 3, 2 },
                { 3, 5 },
        };
        System.out.println(bipartiteRoadConstruct.solve(A, B));
    }
}
