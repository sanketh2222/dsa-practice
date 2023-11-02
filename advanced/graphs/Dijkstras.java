import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstras {

    public class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

    }
    

    //C refers to initial source node
    public int[] solve(int A, int[][] B, int C) {
        List<List<Pair>> adjList = buildAdjLst(A, B);
        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[C] = 0;
        Queue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        minHeap.offer(new Pair(C, 0));
        flo\

        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            int u = p.node;// next src

            for (int i = 0; i < adjList.get(u).size(); i++) {
                Pair adjPair = adjList.get(u).get(i);
                int v = adjPair.node;
                int w = adjPair.dist;

                if (distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                    minHeap.offer(new Pair(v, distance[v]));
                }
            }

        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }

        return distance;
    }

    private List<List<Pair>> buildAdjLst(int n, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        return adjList;
    }

    public static void main(String[] args) {
        Dijkstras dijkstras = new Dijkstras();
        int A = 6;
        int[][] B = { { 0, 4, 9 },
                { 3, 4, 6 },
                { 1, 2, 1 },
                { 2, 5, 1 },
                { 2, 4, 5 },
                { 0, 3, 7 },
                { 0, 1, 1 },
                { 4, 5, 7 },
                { 0, 5, 1 } };
        int C = 4;
        int[] distance = dijkstras.solve(A, B, C);
        Arrays.stream(distance).forEach(System.out::println);
        final int i;
        i =10;
        System.out.println(i);

    }
}
