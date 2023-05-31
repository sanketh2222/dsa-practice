

import java.util.Arrays;

public class CountSort {

    public int[] solve(int[] A) {
        //find max element in the array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        int[] result = new int[A.length];
        int[] cs = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            cs[A[i]]++;
        }

        int index = 0;
        for (int i = 1; i < cs.length; i++) {
            while(cs[i] > 0){
                result[index++] = i;
                cs[i]--;
            }
               
        }
        // Arrays.stream(result).forEach(System.out::print);

        return result;
    }
    
    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] A = { 6, 3, 3, 6, 7, 8, 7, 3, 7};
        countSort.solve(A);
        
    }
}
