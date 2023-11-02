package heaps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.Query;

public class FreeCars {

    public class Pair implements Comparable<Pair> {
        int time;
        int profit;

        Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.time - pair.time;
        }

    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Pair[] carPairs = new Pair[A.size()];
        List<Pair> sortedCarPaits = new ArrayList<>();
        int maxProfit = 0;
        int mod = 1000000007;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            carPairs[i] = new Pair(A.get(i), B.get(i));
            sortedCarPaits.add(carPairs[i]);

        }

        Collections.sort(sortedCarPaits);

        for (Pair pair : sortedCarPaits) {
            if (heap.size() < pair.time) {
                heap.add(pair.profit);
                maxProfit = ((maxProfit % mod) + (pair.profit % mod) % mod);
            } else if ((heap.size() == pair.time) && (heap.peek() < pair.profit)) {
                maxProfit = ((maxProfit % mod) - (heap.poll() % mod)) % mod;
                maxProfit = ((maxProfit % mod) + (pair.profit % mod)) % mod;
                heap.add(pair.profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        FreeCars cars = new FreeCars();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));
        System.out.println(cars.solve(A, B));

    }
}
