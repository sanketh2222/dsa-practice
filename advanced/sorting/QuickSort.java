public class QuickSort {
    public void quickSort(int A[], int N) {
        quickSort(A, 0, N - 1);
    }

    private void quickSort(int A[], int s, int e) {
        if (s < e) {
            int pivotIndex = partition(A, s, e);
            // Recursively sort elements before and after the pivot
            quickSort(A, s, pivotIndex - 1);
            quickSort(A, pivotIndex + 1, e);
        }
    }

    private int partition(int A[], int s, int e) {
        int pivot = A[s]; // Choosing the first element as the pivot
        int l = s + 1; // Index to keep track of elements less than pivot
        int r = e; // Index to keep track of elements greater than pivot

        while (l <= r) {
            if (A[l] <= pivot) {
                l++;
            } else if (A[r] > pivot) {
                r--;
            } else {
                swap(A, l, r);
                l++;
                r--;
            }
        }

        // Swap pivot with the correct position
        swap(A, s, r);
        return r; // Return the pivot index
    }

    private void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        QuickSort sorter = new QuickSort();
        sorter.quickSort(arr, arr.length);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
