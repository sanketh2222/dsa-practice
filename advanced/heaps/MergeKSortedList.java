package heaps;

import java.util.ArrayList;
import java.util.List;
//import statement for queue and priority queue
import java.util.Queue;
import java.util.PriorityQueue;

public class MergeKSortedList {
    
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		Queue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        kArrays.stream().flatMap(List::stream).forEach(x -> pq.offer(x));

        while (!pq.isEmpty()) {
            sortedList.add(pq.poll());
        }
            
        return sortedList;

	}
}
