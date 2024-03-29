package arrays;


public class FirstMissingNumber {

    public static int firstMissingPositive(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                A[i] = A.length + 1;
            }

        }

        for (int i = 0; i < A.length; i++) {
            int val =Math.abs(A[i]);
            if ( val <= A.length) {
                A[val - 1] = (Math.abs(A[val - 1])) * -1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0)
                return i + 1;
        }

        return A.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1};
        int ans = FirstMissingNumber.firstMissingPositive(arr);
        System.out.println(ans);

    }
}
