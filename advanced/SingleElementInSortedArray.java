package advanced;

import java.util.List;

public class SingleElementInSortedArray {

    public int solve(int[] A) {
        int start = 0, end = A.length - 1;

        while (start <= end ) {
            int mid = start + (end - start) / 2;

            if ((mid & 1) == 1)
                start = mid + 1;
            else if (A[mid] != A[mid + 1]) {
                return A[mid];
            } else {
                end = mid - 1;

            }

        }
        return -1;
    }

    public int solve1(int[] A) {

        for (int i = 0; i < A.length - 1; i+=2) {
            if (A[i] != A[i + 1])
                return A[i];

        }
        return A[A.length - 1];
    }

    public static void main(String[] args) {
        SingleElementInSortedArray elementInSortedArray = new SingleElementInSortedArray();
        int[] arr = {  1, 1, 2, 2, 3 };
        int ans = elementInSortedArray.solve1(arr);
        System.out.println(ans);
       List<Integer> arrlst = List.of(1,1);
       System.out.println(arrlst.get(0) == arrlst.get(1));
       System.out.println(arrlst.get(0).equals(arrlst.get(1)));

    }
}
