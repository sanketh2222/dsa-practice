import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

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

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        // finding indegree
        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            // adding nodes to queue with indegree = 0
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int ind = 0;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;
            cnt++;
            // getting neighbour nodes of popped node and decreasing their
            // indegree by1
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        // printing topological ordering of nodes
        for (int i = 0; i < topo.length; i++) {
            System.out.print(topo[i] + " ");
        }
        if (cnt == N)
            return false;
        return true;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        int[][] B = { { 6, 3 },
                { 6, 1 },
                { 5, 1 },
                { 5, 2 },
                { 3, 4 },
                { 4, 2 } };
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
