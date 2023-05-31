package revision;

public class PaintersProblem {
    int mod = 10000003;

    public int paint(int A, int B, int[] C) {

        // find the range in which the answer can lie
        int minTime = Integer.MIN_VALUE;
        int maxTime = 0;
        long ans = 0;
        for (int i = 0; i < C.length; i++) {
            if (C[i] > minTime) {
                minTime = C[i];
            }

            maxTime = ((maxTime % mod) + (C[i] % mod) % mod);

        }

        if (A >= C.length) {
            return minTime * B;
        }

        // check if the ans is possible

        int low = minTime;
        int high = maxTime;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(C, A, mid)) {
                ans = mid;
                // left side
                high = mid - 1;
            } else {
                // right side
                low = mid + 1;
            }
        }

        // if possible try to reduce the ans further

        return (int) (((ans % mod) * (B % mod)) % mod);

    }

    private boolean check(int[] arr, int totalPainters, int minTime) {
        int totalPaintersConsumed = 1;

        int totalBoardsPointed = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minTime) {
                return false;

            } else if (totalBoardsPointed + arr[i] > minTime) {
                totalPaintersConsumed += 1;
                totalBoardsPointed = arr[i];

            } else {
                totalBoardsPointed += arr[i];
            }
        }

        return totalPaintersConsumed > totalPainters ? false : true;
    }

    public static void main(String[] args) {
        PaintersProblem paintersProblem = new PaintersProblem();
        int[] arr = {185, 186, 938, 558, 655, 461, 441, 234, 902, 681  };
        System.out.println(paintersProblem.paint(3, 10, arr));
    }
}
