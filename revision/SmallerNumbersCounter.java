package revision;

import java.util.Arrays;

public class SmallerNumbersCounter {
    public int[] solve(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i], max);
        }
        int[] ans = new int[A.length];
        int[] count = new int[max + 1];

        for (int i = 0; i < A.length; i++) {
            count[A[i]] += 1;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                ans[i] = 0;

            } else {
                ans[i] = count[A[i] - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SmallerNumbersCounter counter = new SmallerNumbersCounter();
        int[] arr = { 18, 30, 32, 33, 51, 40, 53, 75 };
        Arrays.stream(counter.solve(arr)).forEach(System.out::println);

    }
}
