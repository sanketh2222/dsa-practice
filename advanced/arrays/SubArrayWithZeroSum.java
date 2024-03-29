package arrays;


import java.util.HashSet;
import java.util.Set;

import SubArrayWithZeroSum;

public class SubArrayWithZeroSum {

    Set<Integer> hashSet = new HashSet<Integer>();

    public int solve(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (sum == 0)
                return 1;
            else if (hashSet.contains(sum)) {
                return 1;
            } else {
                hashSet.add(sum);
            }
        }


        return 0;
    }
    
    public static void main(String[] args) {
        SubArrayWithZeroSum arrayWithZeroSum = new SubArrayWithZeroSum();
        int[] arr = {1, -1};
        int ans = arrayWithZeroSum.solve(arr);
        System.out.println(ans);
        
    }
}
