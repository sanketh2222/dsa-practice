package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        B.forEach(x -> maxHeap.add(x));
        int maxChocolatesAte = 0;
        int mod = 1000000007;

        while (A > 0) {
            int maxChocolate = maxHeap.poll();
            maxChocolatesAte = ((maxChocolatesAte % mod) + (maxChocolate % mod)) % mod;
            maxHeap.add(maxChocolate / 2);
            A -= 1;
        }

        return  maxChocolatesAte;
    }

    public static void main(String[] args) {
        MagicianAndChocolates andChocolates = new MagicianAndChocolates();
        int ans = andChocolates.nchoc(10, new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647)));
        System.out.println(ans);
        // System.out.println(562281349 - 284628164);

    }
}
