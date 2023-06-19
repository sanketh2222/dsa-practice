package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

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

            if (maxHeap.size() > minHeap.size()) {
                int ele = maxHeap.poll();
                minHeap.offer(ele);

            } else if (minHeap.size() - maxHeap.size() > 1) {
                int ele = minHeap.poll();
                maxHeap.offer(ele);
            }

            ans[i] = i % 2 != 0 ? maxHeap.peek() : minHeap.peek();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 59, 64, 10, 39 };
        RunningMedian median = new RunningMedian();
        int[] ans = median.solve(A);
        Arrays.stream(ans).forEach(System.out::println);
        System.out.println(test().size());
        System.out.println(-1%19);
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
        int maxLimit = lst.size() > 5 ? 5 : lst.size() ;
        return lst.subList(0, maxLimit);
    }

    private boolean checkBit(int n,int i) {
        int ans = n & (1 << i);
        return ans == 0 ? false : true;
    }

    
}
