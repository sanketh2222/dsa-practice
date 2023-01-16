package advanced;

public class PaintersPartitionProblem {

    public int paint(int A, int B, int[] C) {
        // find sum and max element
        int totalBoardUnits = 0, maxBoardUnit = Integer.MIN_VALUE;
        long minTimeTaken = 0;

        for (int i = 0; i < C.length; i++) {
            maxBoardUnit = Math.max(maxBoardUnit, C[i]);
            totalBoardUnits += C[i];
        }

        if (A >= C.length)
            return B * maxBoardUnit;

        int low = maxBoardUnit, high = totalBoardUnits;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(C, A, mid)) {
                minTimeTaken = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return (int) (minTimeTaken % 10000003 * B % 10000003 ) %10000003;
    }

    private boolean check(int arr[], int totalPainters, int minTimeTaken) {
        int totalPaintersConsumed = 1;
        int totalTimeTaken = 0;

        totalTimeTaken = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minTimeTaken) {
                return false;

            } else if ((totalTimeTaken + arr[i]) > minTimeTaken) {
                totalTimeTaken = arr[i];
                totalPaintersConsumed += 1;

            } else {
                totalTimeTaken += arr[i];
            }
        }

        return totalPaintersConsumed > totalPainters ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = { 1000000, 1000000};
        PaintersPartitionProblem paintersPartitionProblem = new PaintersPartitionProblem();
        int ans = paintersPartitionProblem.paint(1, 1000000, arr);
        System.out.println(ans);

    }
}
