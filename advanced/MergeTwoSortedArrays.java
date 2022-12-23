package advanced;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public int[] solve(final int[] A, final int[] B) {

        return merge(A, B);
    }

    public int[] merge(final int[] A, final int[] B) {
        int i = 0, j = 0, k = 0;

        int[] C = new int[A.length + B.length];

        while (i < A.length && j < B.length) {

            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }

        while (j < B.length) {
            C[k++] = B[j++];
        }
        return C;
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] A = { 4, 7, 9 };
        int[] B = { 2, 11, 19 };
        int[] mergedArr = mergeTwoSortedArrays.solve(A, B);
        Arrays.stream(mergedArr).forEach(num -> System.out.print(num + " "));

        //array copy logic
        // int[] ans = new int[mergedArr.length];

        // ans = Arrays.copyOf(mergedArr, mergedArr.length);

        // System.out.println();

        // Arrays.stream(ans).forEach(num -> System.out.print(num + " "));

        

    }
}
