import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiphartiteCheck {

    public int solve(int A, int[][] B) {
        int[] color = new int[A + 1];
        Arrays.fill(color, -1);
        List<List<Integer>> adjLst = buildAdjLst(B, A);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < A; i++) {

            // new component
            if (color[i] == -1) {
                color[i] = 0;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int j = 0; j < adjLst.get(node).size(); j++) {
                        int adjNode = adjLst.get(node).get(j);

                        if (color[adjNode] == -1) {
                            color[adjNode] = 1 - color[node];
                            queue.offer(adjNode);

                        } else if (color[adjNode] == color[node]) {
                            return 0;
                        }
                    }
                }
            }
        }

        return 1;
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
        BiphartiteCheck biphartiteCheck = new BiphartiteCheck();
        int A = 3;
        int[][] B = { {0, 1}, {0, 2}, {1, 2} };
        System.out.println(biphartiteCheck.solve(A, B));
    }
}
