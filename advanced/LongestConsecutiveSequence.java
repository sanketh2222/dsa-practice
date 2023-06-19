

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {

    Set<Integer> hashSet = new HashSet<Integer>();

    public int longestConsecutive(final int[] A) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }

        for (int i = 0; i < A.length; i++) {

            if (!hashSet.contains(A[i] - 1)) {
                int l = 0, x = A[i];
                while (hashSet.contains(x)) {
                    l += 1;
                    x += 1;
                }
                ans = Math.max(ans, l);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
        int[] arr = {2,1};
        int ans = consecutiveSequence.longestConsecutive(arr);
        System.out.println(ans);
    }
}
