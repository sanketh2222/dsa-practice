package advanced;

import java.util.ArrayList;
import java.util.List;

public class Flip {

    public int[] flip(String A) {
        char[] arr = A.toCharArray();
        int[] binaryArray = new int[arr.length];
        int[] ans = {-1,-1};
        int sum = 0, start = 0;
        
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                binaryArray[i] = 1;
            } else {
                binaryArray[i] = -1;
            }
        }

        int maxSum = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            sum += binaryArray[i];

            if (sum < 0){
                sum = 0;
                start = i + 1;
            }

            if (maxSum < sum) {
                maxSum = sum;
                ans[0] = start + 1;
                ans[1] = i + 1;
            }
            // maxSum = Math.max(maxSum, sum);

            // if (sum > 0 && start == -1) {
            //     start = i;
            // }
            // if (sum > 0) {
            //     end = i;
            // } else {
            //     sum = 0;
            //     start = -1;
            // }

            // if ((start > 0 && end > 0) && (start < finalStart && end < finalEnd)) {
            //     finalStart = start;
            //     finalEnd = end;
            // }
        }

        if (ans[0] == -1){
            return new int[2];
        }

        return ans;
    }

    public static void main(String[] args) {
        Flip flip = new Flip();
        String A = "0010010";
        int[] ans = flip.flip(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
