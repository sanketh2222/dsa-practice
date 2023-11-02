import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumSpanningTree {

    public static class Pair {
        int node;
        int parent;
        int weight;

        public Pair(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }

    }

    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        ArrayList<ArrayList<ArrayList<Integer>>> adj = buildAdjacencyList(edges, V, E);
        Queue<Pair> queue = new PriorityQueue<>((x, y) -> (x.weight - y.weight));
        int[] visited = new int[V];
        int sum = 0;
        int count = 0;
        queue.offer(new Pair(0, 0, -1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int wt = pair.weight;
            int node = pair.node;

            if (visited[node] == 1)
                continue;

            visited[node] = 1;
            sum += wt;

            // Total execution time = total no. of edges
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int adjNodeWt = adj.get(node).get(i).get(1);

                if (visited[adjNode] == 0) {
                    count += 1;
                    queue.offer(new Pair(adjNode, node, adjNodeWt));
                }
            }
        }
        System.out.println("total count is " + count);
        return sum;

    }

    private static ArrayList<ArrayList<ArrayList<Integer>>> buildAdjacencyList(int[][] edges, int V, int E) {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        return adj;

    }

    public static void main(String[] args) {
        int V = 2;
        int E = 3;
        int[][] edges = {
                { 0, 1, 5 },
                { 1, 2, 3 },
                { 0, 2, 1 }
        };
        spanningTree(V, E, edges);

    }
}
