package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

    // /https://www.scaler.com/academy/mentee-dashboard/class/52252/assignment/problems/4369?navref=cl_tt_lst_sl

    public int[] solve(int[] A) {
        int[] ans = new int[A.length];
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.offer(A[0]);
        ans[0] = A[0];

        for (int i = 1; i < A.length; i++) {

            if (A[i] > maxHeap.peek()) {
                minHeap.offer(A[i]);

            } else {
                maxHeap.offer(A[i]);
            }

            if ((maxHeap.size() - minHeap.size() > 1)) {
                minHeap.offer(maxHeap.poll());

            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            ans[i] = maxHeap.peek();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 59, 64, 10, 39 };
        RunningMedian median = new RunningMedian();
        int[] ans = median.solve(A);
        Arrays.stream(ans).forEach(System.out::println);
        System.out.println(test().size());
        System.out.println(-1 % 19);
        System.out.println(1 ^ 1);
    }

    private static List<Integer> test() {
        List<Integer> lst = new ArrayList<>();
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        int maxLimit = lst.size() > 5 ? 5 : lst.size();
        return lst.subList(0, maxLimit);
    }

    private boolean checkBit(int n, int i) {
        int ans = n & (1 << i);
        return ans == 0 ? false : true;
    }

}
