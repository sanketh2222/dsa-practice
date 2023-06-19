

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DirectGraphPath {

    public int solve(int A, int[][] B) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(B);
        boolean[] isVisted = new boolean[A + 1];
        q.offer(1);

        while (!q.isEmpty()) {
            int vistedNode = q.poll();
            isVisted[vistedNode] = true;

            if (adjacencyList.get(vistedNode) == null) {
                return isVisted[A] ? 1 : 0;
            }
            for (int i = 0; i < adjacencyList.get(vistedNode).size(); i++) {
                if (!isVisted[adjacencyList.get(vistedNode).get(i)])
                    q.offer(adjacencyList.get(vistedNode).get(i));
            }
        }

        return isVisted[A] ? 1 : 0;
    }

    private Map<Integer, List<Integer>> buildAdjacencyList(int[][] adjMatrix) {
        Map<Integer, List<Integer>> adjLst = new HashMap<>();
        for (int[] row : adjMatrix) {
            adjLst.getOrDefault(row[0], new ArrayList<>()).add(row[1]);
            adjLst.put(row[0], adjLst.get(row[0]));
        }
        return adjLst;
    }

    public static void main(String[] args) {
        DirectGraphPath directGraphPath = new DirectGraphPath();
        int A = 5;
        int[][] B = { { 1, 2 },
                { 4, 1 },
                { 2, 4 },
                { 3, 4 },
                { 5, 2 },
                { 1, 3 } };
        System.out.println(directGraphPath.solve(A, B));

    }
}
