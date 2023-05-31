import java.util.ArrayList;
import java.util.List;

public class CommutableIslands {

    public class Edge {
        int u;
        int v;
        int wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

    }

    public int solve(int A, int[][] B) {
        List<Edge> edges = new ArrayList<>();
        int minCost = 0;
        int[] comp = new int[A + 1];

        for (int i = 1; i < comp.length; i++) {
            comp[i] = i;
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int wt = B[i][2];

            edges.add(new Edge(u, v, wt));
        }
        edges.sort((a, b) -> a.wt - b.wt);

        minCost = edges.stream().map(x -> getMinCost(x, comp)).reduce(minCost, (a, b) -> a + b);
        return minCost;
    }

    private int getMinCost(Edge edge, int[] comp) {
        int u = edge.u;
        int v = edge.v;
        int w = edge.wt;

        int cu = findComp(comp, u);
        int cv = findComp(comp, v);

        if (cu != cv) {
            comp[Math.max(cu, cv)] = comp[Math.min(cu, cv)];
            return w;
        }

        return 0;
    }

    private int findComp(int[] comp, int x) {
        if (comp[x] == x) {
            return x;
        }

        comp[x] = findComp(comp, comp[x]);

        return comp[x];
    }

    public static void main(String[] args) {
        CommutableIslands commutableIslands = new CommutableIslands();
        int A = 4;
        int[][] B = { { 1, 2, 1 },
                { 2, 3, 4 },
                { 1, 4, 3 },
                { 4, 3, 2 },
                { 1, 3, 10 } };
        System.out.println(commutableIslands.solve(A, B));
    }
}
