package arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

    public static int[] maxset(int[] A) {
        int currStart = 0, start = 0, currEnd = 0, end = -1;
        long sum = 0, ans = Long.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {

                if (sum == ans) {
                    int prevLength = (end - start) + 1;
                    int currLength = (currEnd - currStart) + 1;

                    // subarray length check
                    if (currLength > prevLength) {
                        start = currStart;
                        end = currEnd;
                    }

                    // index check
                    if ((currLength == prevLength) && (currStart > start)) {
                        start = currStart;
                        end = currEnd;
                    }

             

                }
                sum = 0;
                currStart = i + 1;
            } else if (i == A.length - 1 && (sum + A[i] > ans)) {
                start = currStart;
                end = i;
                ans = Math.max(ans, sum);
            } else {
                sum += A[i];
                ans = Math.max(ans, sum);
                currEnd = i;
            }
        }

        if (ans == Long.MIN_VALUE)
            return result.stream().mapToInt(x -> x).toArray();

        for (int i = start; i <= end; i++) {
            result.add(A[i]);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr = { 25150, 1412, 82797, 48381, 7065, -47699, -25129, -65483, -64607, -45322, -55176, 27224, 80366, 60444, 70285, -93898, -41133, 96576, -58266, 21711, -20614, -95737, 20591, -48762, -76197, -38588, -54873, 37304, 61200, -68960, 93947  };
        //27224 +80366 +60444 +70285 -> 238319
        //93947  
        int[] res = MaxNonNegativeSubArray.maxset(arr);
        Arrays.stream(res).forEach(System.out::print);
        // int sum = Arrays.stream(res).sum();
        // System.out.println(sum);

    }
}
