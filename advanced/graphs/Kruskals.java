import java.util.ArrayList;
import java.util.List;

public class Kruskals {

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
        List<Edge> lst = new ArrayList<>();
        int[] comp = new int[A + 1];
        int minCost = 0;
        int mod = 1000000007;

        for (int i = 0; i < comp.length; i++) {
            comp[i] = i;
        }

        for (int i = 0; i < B.length; i++) {
            lst.add(new Edge(B[i][0], B[i][1], B[i][2]));
        }
        // Sort based on edge weights
        lst.sort((a, b) -> (a.wt - b.wt));

        minCost = lst.stream().map(x -> getMinCostEdge(x, comp)).reduce(minCost, (a, b) -> ((a % mod) + (b % mod)) % mod);
        return minCost;
    }

    private int getMinCostEdge(Edge edge, int[] comp) {
        int cu = findComp(comp, edge.u);
        int cv = findComp(comp, edge.v);

        if (cu != cv) {
            comp[Math.max(cu, cv)] = comp[Math.min(cu, cv)];// error
            return edge.wt;
        }

        return 0;
    }

    public static void main(String[] args) {
        Kruskals kruskals = new Kruskals();
        int[][] B = { { 1, 2, 14 }, { 2, 3, 7 }, { 3, 1, 2 } };
        int ans = kruskals.solve(3, B);
        System.out.println(ans);
        // List<String> lst = List.of("");

    }

    private int findComp(int[] comp, int x) {
        // while trying to find the root component, we have to try to go till it returns
        // the same value
        if (comp[x] == x) {
            return x;
        }
        comp[x] = findComp(comp, comp[x]);
        return comp[x];
    }
}
