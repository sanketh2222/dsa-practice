public class SlowMango {

    public int solve(int[] A, int B) {
        int low = 0;
        int high = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            low = Math.max(low, A[i]);
            high += A[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(A, mid, B)) {
                high = mid - 1;
                ans = Math.min(ans, mid);

            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    private boolean check(int[] arr, int k, int B) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int) Math.ceil(Double.valueOf(arr[i]) / k);
        }

        return sum > B ? false : true;
    }

    public static void main(String[] args) {
        SlowMango mango = new SlowMango();
        int[] arr = { 2, 5, 7, 10, 7, 1, 3, 7 };
        int B = 17;
        System.out.println(mango.solve(arr, B));
    }
}
