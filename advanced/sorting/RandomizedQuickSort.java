public class RandomizedQuickSort {

    public void quickSort(int arr[], int N) {
        quickSort(arr, 0, N - 1);
    }

    private void quickSort(int arr[], int s, int e) {
        if (s < e) {
            int pivotIndex = randomizedPartition(arr, s, e);

            // Recursively sort elements before and after the pivot
            quickSort(arr, s, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, e);
        }
    }

    private int randomizedPartition(int arr[], int s, int e) {
        // Generate a random index between s and e inclusive
        int randomIndex = s + (int) (Math.random() * (e - s + 1));

        // Swap the random pivot with the first element
        swap(arr, s, randomIndex);

        return partition(arr, s, e);
    }

    private int partition(int arr[], int s, int e) {
        int pivot = arr[s]; // Choosing the first element as the pivot
        int l = s + 1; // Index to keep track of elements less than pivot
        int r = e; // Index to keep track of elements greater than pivot

        while (l <= r) {
            if (arr[l] <= pivot) {
                l++;
            } else if (arr[r] > pivot) {
                r--;
            } else {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        // Swap pivot with the correct position
        swap(arr, s, r);
        return r; // Return the pivot index
    }

    private void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        RandomizedQuickSort sorter = new RandomizedQuickSort();
        sorter.quickSort(arr, arr.length);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: Sorted array: 2 3 5 6 7 9 10 11 12 14
    }
}
