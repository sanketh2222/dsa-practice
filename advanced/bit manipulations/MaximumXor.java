

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumXor {

    //use concept of trie
    
    public class Node {
        Node[] ch = new Node[2];

        Node() {
            ch[0] = null;
            ch[1] = null;
        }

    }

    public int solve(int[] A) {
        int maxXor = 0;
        Node root = new Node();
        int maxElement = getMax(A);
        int maxSetBit = (int) (Math.log(maxElement) / Math.log(2));

        for (int i = 0; i < A.length; i++) {
            insert(A[i], maxSetBit, root);
        }

        for (int i = 0; i < A.length; i++) {
            maxXor = Math.max(maxXor, query(A[i], maxSetBit, root));
        }

        return maxXor;
    }

    private void insert(int ele, int maxSetBit, Node root) {
        for (int i = maxSetBit; i >= 0; i--) {
            int eleBit = ele >> i & 1;

            if (root.ch[eleBit] == null) {
                Node n = new Node();
                root.ch[eleBit] = n;
                root = n;

            } else {
                root = root.ch[eleBit];
            }
        }
    }

    private int query(int ele, int maxSetBit, Node root) {
        int ans = 0;
        for (int i = maxSetBit; i >= 0; i--) {
            int eleBit = ele >> i & 1;
            if (root.ch[1 - eleBit] != null) {
                ans = ans + (1 << i);
                root = root.ch[1 - eleBit];

            } else {
                root = root.ch[eleBit];
            }
        }
        return ans;
    }

    private int getMax(int[] A) {
        return Arrays.stream(A).max().getAsInt();
    }

    public static void main(String[] args) {
        MaximumXor maximumXor = new MaximumXor();
        int[] arr = { 5, 17, 100, 11 };
        // System.out.println(maximumXor.solve(arr));
        // Map<String,?> mp = returnMap();

    }

  
}
