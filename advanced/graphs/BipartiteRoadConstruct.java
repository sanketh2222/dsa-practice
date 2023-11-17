import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteRoadConstruct {
    // https://www.scaler.com/academy/mentee-dashboard/class/70693/assignment/problems/9424?navref=cl_tt_lst_sl

    // 1 -> red 0 -> blue
    public int solve(int A, int[][] B) {
        List<List<Integer>> adjList = buildAdjLst(B, A);
        Queue<Integer> queue = new LinkedList<>();
        int[] colour = new int[A + 1];
        Arrays.fill(colour, -1);
        int set1 = 1;
        int set2 = 0;
        colour[1] = 1;
        queue.offer(1);
        int mod = 1000000007;


        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i);
                if (colour[v] == -1) {
                    colour[v] = 1 - colour[u]; // invert the adj colour
                    if (colour[v] == 1) {
                        set1 += 1;
                    } else {
                        set2 += 1;
                    }
                    queue.offer(v);
                }
            }
        }
        int extra = (int) (((long)set1 * set2) % mod);
        extra = (int)(((extra - (A - 1)) % mod + mod) % mod);

        return extra;
    }

    /**
     * 
     * @param B edges array(u,v and wt)
     * @param A no. of nodes
     * @return
     */
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
        BipartiteRoadConstruct bipartiteRoadConstruct = new BipartiteRoadConstruct();
        int A = 5;
        int[][] B = {
                { 1, 3 },
                { 1, 4 },
                { 3, 2 },
                { 3, 5 },
        };
        System.out.println(bipartiteRoadConstruct.solve(A, B));
    }
}
