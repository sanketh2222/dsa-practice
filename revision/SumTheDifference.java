package revision;

public class SumTheDifference {

    int mod = 1000000007;

    public int solve(int[] A) {
        int sum = 0;
        int maxContrib = 0;
        int minContrib = 0;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            maxContrib = (2 << i);
            minContrib = (2 << n - 1 - i);
            sum = ((sum % mod) + ((A[i] % mod) * (maxContrib % mod - minContrib % mod))) % mod;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumTheDifference difference = new SumTheDifference();
        int[] arr = { 3, 5, 10 };
        System.out.println(difference.solve(arr));
    }
}
