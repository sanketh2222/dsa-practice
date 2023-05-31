import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {

    public int[] solve(int A, int[][] B) {
        int[] nodeDependencies = new int[A + 1];
        Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> orderLst = new ArrayList<>();
        Map<Integer, List<Integer>> adjLst = buildAdjacencyList(B);

        adjLst.entrySet().stream().forEach(x -> x.getValue().stream().forEach(y -> nodeDependencies[y] += 1));
        for (int i = 1; i <= A; i++) {
            if (nodeDependencies[i] == 0) {
                queue.offer(i);
                // break;
            }
        }

        while (!queue.isEmpty()) {
            int ele = queue.poll();
            orderLst.add(ele);

            if (adjLst.get(ele) == null) {
                continue;
            }

            for (int i = 0; i < adjLst.get(ele).size(); i++) {
                int node = adjLst.get(ele).get(i);
                nodeDependencies[node] -= 1;
                if (nodeDependencies[node] == 0) {
                    queue.offer(node);
                }
            }
           
        }
        return orderLst.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        int[][] B = { {6, 3},
            {6, 1},
            {5, 1},
            {5, 2},
            {3, 4},
            {4, 2}};
        int[] ans = topologicalSort.solve(8, B);
        // int[] arr = { 1, 2, 3, 4, 5, 6 };
        // Arrays.stream(arr).skip(1).forEach(System.out::print);

        // for (Map.Entry<Integer, List<Integer>> entry : adjLst.entrySet()) {
        // // for (int i = 0; i < entry.getValue().size(); i++) {
        // // dep[entry.getValue().get(i)] += 1;
        // // }
        // entry.getValue().stream().map(x -> dep[x] += 1).collect(Collectors.toList());

        // }
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static Map<Integer, List<Integer>> buildAdjacencyList(int[][] adjMatrix) {
        Map<Integer, List<Integer>> adjLst = new HashMap<>();
        for (int[] row : adjMatrix) {
            List<Integer> lst = adjLst.getOrDefault(row[0], new ArrayList<>());
            lst.add(row[1]);
            adjLst.put(row[0], lst);
        }
        return adjLst;
    }

}
