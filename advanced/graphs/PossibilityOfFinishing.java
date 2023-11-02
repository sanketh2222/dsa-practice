import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PossibilityOfFinishing {

    public int solve(int A, int[] B, int[] C) {
        int totalComponents = findTotalComponents(B, C, A);
        int totalEdges = B.length;
        if (totalEdges >= A) {
            return 0;

        } else if (totalEdges > A - totalComponents) {
            return 0;
        }
        return 1;
    }

    static boolean checkCycle(int V, int E, Map<Integer, List<Integer>> adjLst) {
        int deg[] = new int[V];

        // Computing indegree of
        // each vertex using.
        for (int i = 0; i < V; i++)
            for (int x : adjLst.get(i))
                deg[x]++;

        // Queue to store vertices
        // with having 0 indegree.
        Queue<Integer> q = new LinkedList<>();

        // Iterate from i = 0 To i
        // = V - 1 and find vertices
        // having indegree as 0.
        for (int i = 0; i < V; i++)
            if (deg[i] == 0)
                q.add(i);

        // Defining the counter.
        int counter = 0;

        // Iterating while the queue is
        // not empty.
        while (!q.isEmpty()) {
            // Dequeue from 'q'.
            int u = q.poll();

            // Increase the counter.
            counter++;

            // Iterate for all neighours
            // of vertex 'u'.
            for (int v : adjLst.get(u)) {
                // Decrease the indegree.
                deg[v]--;

                // If deg[v] is 0, insert
                // it the q.
                if (deg[v] == 0)
                    q.add(v);
            }
        }

        // Returning true if counter != V.
        return counter != V;
    }

    private int findTotalComponents(int[] u, int[] v, int n) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> adjLst = buildAdjLst(u, v);
        Queue<Integer> queue = new PriorityQueue<>();
        int[] nodeDependencies = buildDependencyArr(adjLst, n, queue);
        int totalComponents = 0;
        // for (int i = 1; i <= n; i++) {
        // if (visited[i] == false) {
        // dfs(visited, adjLst, i);
        // totalComponents++;
        // }
        // }

        while (!queue.isEmpty()) {
            int ele = queue.poll();
            if (visited[ele] == false) {
                dfs(visited, adjLst, ele);
                totalComponents++;
            }
        }
        return totalComponents;
    }

    private int[] buildDependencyArr(Map<Integer, List<Integer>> adjLst, int n, Queue<Integer> queue) {
        int[] nodeDependencies = new int[n + 1];
        adjLst.entrySet().stream().forEach(x -> x.getValue().stream().forEach(y -> nodeDependencies[y] += 1));
        for (int i = 1; i <= n; i++) {
            if (nodeDependencies[i] == 0) {
                queue.offer(i);
            }
        }

        return nodeDependencies;
    }

    private Map<Integer, List<Integer>> buildAdjLst(int[] u, int[] v) {
        Map<Integer, List<Integer>> adjLst = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            List<Integer> lst = adjLst.getOrDefault(u[i], new ArrayList<>());
            lst.add(v[i]);
            adjLst.put(u[i], lst);
        }

        return adjLst;
    }

    private void dfs(boolean[] visited, Map<Integer, List<Integer>> adjLst, int src) {

        if (visited[src] == true)
            return;

        visited[src] = true;

        if (adjLst.get(src) == null) {
            return;
        }
        for (int i = 0; i < adjLst.get(src).size(); i++) {
            dfs(visited, adjLst, adjLst.get(src).get(i));
        }

    }

    public static void main(String[] args) {
        int A = 5;
        int[] B = { 1, 3, 4, 5 };
        int[] C = { 2, 1, 5, 3 };
        PossibilityOfFinishing finishing = new PossibilityOfFinishing();
        System.out.println(finishing.solve(A, B, C));

    }
}
