package advanced;

import java.util.Arrays;

public class AggressiveCows {

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 0, high = A[A.length - 1];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(A, mid, B)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] arr, int minDistance, int totalCows) {
        int noOfPlacedCows = 1;
        int currCowPos = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - currCowPos) >= minDistance) {
                noOfPlacedCows += 1;
                currCowPos = arr[i];
            }

            if (noOfPlacedCows == totalCows)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        AggressiveCows aggressiveCows = new AggressiveCows();
        int[] arr = { 0, 1000000000 };
        int ans = aggressiveCows.solve(arr, 385);
        System.out.println(ans);
    }
}
