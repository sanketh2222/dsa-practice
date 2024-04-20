package sorting;

public class MergeSort {

    // Example: arr[] = {12, 11, 13, 5, 6, 7}
    // sligtly bigger example: arr[] = {38, 27, 43, 3, 9, 82, 10}
    //Time complexity of Merge Sort is O(n*Log n) in all the 3 cases (worst, average and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
    //It requires equal amount of additional space as the unsorted array. Hence its not at all recommended for arrays of large sizes.
    //Space complexity of Merge Sort is O(n) in all the 3 cases because of the additional space required for the temporary arrays.
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // l is for left index and r is right index of the sub-array to be sorted and m
    // is the middle index
    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
