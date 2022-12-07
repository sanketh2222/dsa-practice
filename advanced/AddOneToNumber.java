package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddOneToNumber {
    public static int[] plusOne(int[] A) {
        boolean isCarry = false;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] + 1 >= 10) {
                A[i] = 0;
                isCarry = true;
            } else if (isCarry) {
                A[i] = 0;
            } else {
                A[i] += 1;
                break;
            }
        }

        if (isCarry || A.length == 1) {
            if (A[0]+ 1 >= 10)
                
            A[0] += 1;
        }

        return A;
    }

    public static int[] plusOneL(int[] A) {
        boolean isCarry = false;
        List<Integer> ans = new ArrayList<Integer>(Collections.nCopies(A.length + 2, 0));
        // ans.add(0, null);
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] + 1 >= 10) {
                A[i] = 0;
                ans.set(i, 0);
                isCarry = true;
            } else if (isCarry) {
                A[i] = 0;
                ans.set(i, 0);
            } else {
                A[i] += 1;
                ans.set(A[i], 0);
                break;
            }
        }

        if (isCarry || A.length == 1) {
            if (A[0]+ 1 >= 10){
                ans.add(0, 1);
                ans.set(1, 0);
            }else{
                A[0] += 1;
                ans.set(0, A[0]);
            }
                

        }

        return ans.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] ans = AddOneToNumber.plusOneL(arr);
        Arrays.stream(ans).forEach(System.out::print);

    }
}
