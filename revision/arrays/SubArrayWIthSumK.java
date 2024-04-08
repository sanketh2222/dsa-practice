package revision.arrays;

public class SubArrayWIthSumK {

    public int solve(int[] A, int B) {
        int n = A.length;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            while (sum > B) {
                sum -= A[start];
                start++;
            }
            if (sum == B) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SubArrayWIthSumK subArrayWIthSumK = new SubArrayWIthSumK();
        int[] arr = { 1, 2, 3, 4, 5 };
        int B = 10;
        System.out.println(subArrayWIthSumK.solve(arr, B));
    }
}
