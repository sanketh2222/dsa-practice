package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static final int TARGET_SUM = 0;

    public static int[][] threeSum(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        List<List<Integer>> tripplets = new ArrayList<>();
        for (int low = 0; low < n - 2; low++) {

            if (low > 0 && A[low] == A[low - 1])
                continue; // avoid duplicate
            // 2 sum sorted
            int mid = low + 1;
            int high = n - 1;

            while (mid < high) {
                int sum = A[low] + A[mid] + A[high];

                if (sum == TARGET_SUM) {
                    tripplets.add(Arrays.asList(A[low], A[mid], A[high]));
                    mid++;
                    high--;

                    while (mid < high && A[mid] == A[mid - 1])  mid++; // avoid duplicate
                    while (mid > high && A[high] == A[high + 1]) high--; // avoid duplicate

                } else if (sum < TARGET_SUM) {
                    mid++;
                } else {
                    high--;
                }
            }
        }

        return convertToArr(tripplets);

    }

    private static int[][] convertToArr(List<List<Integer>> triplets) {
        int[][] arr = triplets.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray()) // convert to int array(int[])
                .toArray(int[][]::new); // convert to 2d array
        return arr;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[][] arr = threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
