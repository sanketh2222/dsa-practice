import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlg {

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
        Queue<Pair> pq = new PriorityQueue<>((x, y) -> (x.weight - y.weight));
        int sum = 0;
        int[] vis = new int[V];
        // {wt, node}
        pq.add(new Pair(0, 0, -1));

        while (pq.size() > 0) {

            int wt = pq.peek().weight;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1)
                continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, node, edW));
                }
            }
        }
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

}