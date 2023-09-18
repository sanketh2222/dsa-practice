package revision;

public class PaintersCorrect {

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

    private boolean check(int arr[], int totalPainters, int givenTime) {
        int totalPaintersConsumed = 1;
        int totalTimeTaken = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > givenTime) {
                return false;

            } else if ((totalTimeTaken + arr[i]) > givenTime) {
                totalTimeTaken = arr[i];
                totalPaintersConsumed += 1;

            } else {
                totalTimeTaken += arr[i];
            }
        }

        return totalPaintersConsumed > totalPainters;
    }
    
    public static void main(String[] args) {
        PaintersCorrect paintersProblem = new PaintersCorrect();
        int[] arr = {  1000000, 1000000};
        paintersProblem.paint(1, 1000000, arr);
    }
}
