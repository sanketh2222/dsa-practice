public class EatingBananas {

    //https://www.scaler.com/test/e71616291c/#/problem_2
    public int solve(int[] A, int B) {
        int minTime = Integer.MAX_VALUE, maxTime = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            minTime = Math.min(minTime, A[i]);
            maxTime = Math.max(maxTime, A[i]);
        }

        int low = 1, high = maxTime;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(A, mid, B)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    private boolean check(int[] arr, int speed, int maxTime) {
        int totalTime = 0;
        for (int i = 0; i < arr.length; i++) {
            int time = (arr[i] % speed) == 0 ? (arr[i] / speed) : ((arr[i] / speed) + 1);
            totalTime += time;
        }

        return totalTime <= maxTime;
    }

}
