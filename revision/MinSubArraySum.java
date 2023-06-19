package revision;

public class MinSubArraySum {

    public int solve(int[] A, int B) {
        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int minSum = sum;
        int ans = 0;

        int start = 1;
        int end = B;
        int n = A.length;

        while (end < n) {

            sum -= A[start - 1];
            sum += A[end];

            if (sum < minSum) {
                ans = start;
            }

            start++;
            end++;
        }

        return ans;
    }

    public static void main(String[] args) {
        MinSubArraySum minSubArraySum = new MinSubArraySum();
        // int[] arr = { 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 };
        int[] arr = { 18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19 };
        System.out.println(minSubArraySum.solve(arr, 1));
        String[] arrS = { "xxx", "xxx", "xxx" };
        char[][] mat = new char[arrS.length][arrS[0].length()];
        int n = arrS.length;
        int m = arrS[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = arrS[i].charAt(j);
            }
        }
        String input = "termDeposits ";
        getCategoryName(input);

    }

    private static void getCategoryName(String input) {
        String output = input.replaceAll("([A-Z])", " $1").trim();
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        output = output.replaceAll("(?i)rtgs", "RTGS");
        System.out.println(output);
    }
}
