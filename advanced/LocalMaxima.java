

import java.util.ArrayList;
import java.util.List;

public class LocalMaxima {

    public int solve(int[] A) {
        int low = 1, high = A.length - 2;
        int mid = (low + high) / 2;

        if (A.length == 1)
            return A[0];

        if (A[0] > A[1]) {
            return A[0];

        } else if (A[A.length - 2] < A[A.length - 1]) {
            return A[A.length - 1];
        }

        while (low <= high) {
            mid = (low + high) / 2;

            if ((A[mid - 1] < A[mid]) && (A[mid] > A[mid + 1])) {
                return A[mid];

            } else if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return A[mid];

    }

    public static void main(String[] args) {
        LocalMaxima localMaxima = new LocalMaxima();
        int[] arr = { 1, 1000000000, 1000000000 };
        int ans = localMaxima.solve(arr);
        System.out.println(ans);

    }
}
