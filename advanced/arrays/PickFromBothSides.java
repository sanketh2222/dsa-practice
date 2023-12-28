package arrays;
/**
 * https://www.scaler.com/test/29215ac39c/#/java
 */
public class PickFromBothSides {

    //Brute force
    public static int maxSumAfterBOperations(int[] A, int B) {
        int maxSum = Integer.MIN_VALUE;

        // Try all possible combinations of removing elements
        for (int i = 0; i <= B; i++) {
            int sum = 0;
            // Take i elements from the start
            for (int j = 0; j < i; j++) {
                sum += A[j];
            }
            // Take B-i elements from the end
            for (int j = 0; j < B - i; j++) {
                sum += A[A.length - 1 - j];
            }
            // Update maxSum if the current sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    //Optimal approach
    public int solve(int[] A, int B) {
        int currentSum = 0;
        int maxSum = 0;

        // Calculate the initial sum of removing B elements from the start
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        maxSum = currentSum;

        // Iterate to find the maximum sum by trying different combinations
        for (int i = 0; i < B; i++) {
            currentSum = currentSum - A[B - 1 - i] + A[A.length - 1 - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A1 = { 5, -2, 3, 1, 2 };
        int B1 = 3;
        System.out.println("Maximum Sum for Input 1: " + maxSumAfterBOperations(A1, B1)); // Expected Output: 8

        int[] A2 = { 2, 3, -1, 4, 2, 1 };
        int B2 = 4;
        System.out.println("Maximum Sum for Input 2: " + maxSumAfterBOperations(A2, B2)); // Expected Output: 9
    }

}
