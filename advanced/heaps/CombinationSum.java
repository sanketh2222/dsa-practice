package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// import java.util.Queue;
// import java.util.PriorityQueue;
// import java.util.Arrays;
// import java.util.Collections;

public class CombinationSum {
    public int[] solve(int[] A, int[] B, int C) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int[] result = new int[C];
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = C - 1; i >= 0; i--) {
            pq.offer(A[i] + B[i]);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (i == j) {
                    continue;
                }

                if ((A[i] + B[j]) > pq.peek()) {
                    pq.poll();
                    pq.offer(A[i] + B[j]);
                }
            }
        }

        for (int i = 0; i < C; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = A.size();

        for (int i = 0; i < C; i++) {
            pq.offer(A.get(i) + B.get(i));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                } else if (A.get(i) + B.get(j) > pq.peek()) {
                    pq.poll();
                    pq.offer(A.get(i) + B.get(j));
                } else {
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(pq);
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 68, 35 };
        int[] B = { 68, 35 };
        int C = 1;
        CombinationSum combinationSum = new CombinationSum();
        int[] result = combinationSum.solve(A, B, C);
        
        System.out.println("aab".substring(0,1));

    }
}
