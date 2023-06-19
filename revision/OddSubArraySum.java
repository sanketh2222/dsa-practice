package revision;

public class OddSubArraySum {

    public int solve(int[] A) {
        int totalSum = 0;
        for (int i = 1; i <= A.length; i += 2) {
            totalSum += getSubArraySum(A, i);
        }

        return totalSum;
    }

    private int getSubArraySum(int[] arr, int k) {
        int sum = 0, totalSum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int start = 1, end = k;
        totalSum = sum;
        int n = arr.length;
        while (end < n) {
            sum -= arr[start - 1];
            sum += arr[end];

            totalSum += sum;

            start++;
            end++;
        }

        return totalSum;

    }

    public static void main(String[] args) {
        OddSubArraySum arraySum = new OddSubArraySum();
        int[] arr = { 2, 3, 7 };
        System.out.println(arraySum.solve(arr));
    }
}
