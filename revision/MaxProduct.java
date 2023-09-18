import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProduct {

    public int solve(int[] A) {
        Queue<Integer> mh = new PriorityQueue<>();
        int maxP = 1;

        for (int i = 0; i <= 2; i++) {
            maxP *= A[i];
            mh.offer(A[i]);
        }

        if (A.length == 3) {
            return maxP;
        }

        for (int i = 3; i < A.length; i++) {

            if (A[i] > mh.peek()) {
                maxP /= mh.poll();
                maxP *= A[i];
                mh.offer(A[i]);
            }
        }

        return maxP;
    }

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        int[] arr = { -7, -9, -7, 2, -9, 7, -8, 6, -1 };
        System.out.println(mp.solve(arr));
        double res = Double.valueOf(3)/ 4;
        System.out.println((int)Math.ceil(res));
    }
}
