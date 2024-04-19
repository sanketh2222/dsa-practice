
public class InversionCount {
    long count = 0;
    int mod = 1000000007;

    public int solve(int[] A) {
        inversionCount(A, 0, A.length - 1);
        return (int) count % mod;
    }

    private long inversionCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = (l + r) / 2;
        inversionCount(arr, l, mid);
        inversionCount(arr, mid + 1, r);
        count = ((count % mod) + (merge(arr, l, mid, r) % mod)) % mod;

        return count;

    }

    private int merge(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] C = new int[r - l + 1];
        int k = 0;
        int count = 0;

        while (i <= mid && j <= r) {

            if (arr[i] > (2 * arr[j])) {
                C[k++] = arr[j++];
                count = ((count % mod) + (mid - i + 1) % mod) % mod;
            } else {
                C[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            C[k++] = arr[i++];
        }

        while (j <= r) {
            C[k++] = arr[j++];
        }

        // Copy C to arr
        // for (int x = l; x <= r; x++) {
        //     arr[x] = C[x - l];
        // }
        // Copy C to arr
        for (int x = 0; x < k; x++) {
            arr[x + l] = C[x];
        }

        return count;
    }

    public static void main(String[] args) {
        InversionCount count = new InversionCount();
        int[] arr = { 1, 3, 2, 3, 1 };
        int ans = count.solve(arr);
        System.out.println(ans);

    }
}
