

import java.util.HashMap;
import java.util.Map;

public class CountSubArrays {


    Map<Integer,Long> freqMap = new HashMap<>();

    public int solve(int[] A) {
        int start = 0, end = 0;
        long ans = 0;

        while (end < A.length) {
            if (freqMap.containsKey(A[end])){
                long freq = freqMap.get(A[start]);
                freqMap.put(A[start],--freq);
                start+=1;
            
            } else {
                freqMap.put(A[end],1L);
            }

             ans += (end - start + 1);
        }

        return (int)ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
        
        
    }
}
