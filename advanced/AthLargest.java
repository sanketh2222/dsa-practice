import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class AthLargest {

    public int[] solve(int A, int[] B) {
        int[] ans = new int[B.length];
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B.length; i++) {
            int athLargest = Integer.MAX_VALUE;
            if (i < A - 1) {
                athLargest = -1;

            } else if (minHeap.size() >= A && B[i] > minHeap.peek()) {
                minHeap.poll();
            }

            if (minHeap.size() < A)
                minHeap.offer(B[i]);

            ans[i] = athLargest == Integer.MAX_VALUE ? minHeap.peek() : -1;

        }

        return ans;
    }

    public static void main(String[] args) {
        AthLargest athLargest = new AthLargest();
        int A = 4;
        int[] B = { 1, 2, 3, 4, 5, 6 };
        int[] ans = athLargest.solve(A, B);
        Arrays.stream(ans).forEach(System.out::println);
    }
}
