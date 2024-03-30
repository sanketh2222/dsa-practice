package sorting;


public class ReversePairs {
    long count = 0;
    int mod = 1000000007;

    public int solve(int[] A) {
        count = inversionCount(A, 0, A.length - 1);
        return (int) (count % mod);
    }

    private long inversionCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = (l + r) / 2;
        long ans1 = inversionCount(arr, l, mid);
        long ans2 = inversionCount(arr, mid + 1, r);
        long ans3 = merge(arr, l, mid, r);

        return ans1 + ans2 + ans3;

    }

    private int merge(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] C = new int[r - l + 1];
        int k = 0;
        int count = 0;

        // Counting
        // arr from i to mid is sorted individually
        // arr from mid to r is sorted individually
        while (i <= mid && j <= r) {

            if (arr[i] > (2 * arr[j])) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        i = l;
        j = mid + 1;

        // Sorting
        while (i <= mid && j <= r) {

            if (arr[i] > arr[j]) {
                C[k++] = arr[j++];
            } else {
                C[k++] = arr[i++];
            }
        }

        //
        while (i <= mid) {
            C[k++] = arr[i++];
        }

        while (j <= r) {
            C[k++] = arr[j++];
        }

        // Copy C to arr
        for (int x = l; x <= r; x++) {
            arr[x] = C[x - l];
        }

        return count;
    }

    public static void main(String[] args) {
        ReversePairs pairs = new ReversePairs();
        int[] arr = { 14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137,
                81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611 };
        System.out.println(pairs.solve(arr));

    }
}
