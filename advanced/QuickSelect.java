

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class QuickSelect {
    public static int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        Random random = new Random();
        int pivotIndex = random.nextInt(end - start + 1) + start;
        pivotIndex = partition(arr, start, end, pivotIndex);
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, start, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = start;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int kthsmallest(final List<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A.size(), (a, b) -> a - b);
        for (int num : A) {
            minHeap.offer(num);
        }
        int result = 0;
        for (int i = 0; i < B; i++) {
            result = minHeap.poll();
        }
        return result;
    }
    

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}


