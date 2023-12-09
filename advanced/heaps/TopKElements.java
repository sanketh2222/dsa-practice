package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopKElements {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();

    }
}
