package recursion;


public class SumOfDigitsWithRecursion {

    int ans = 0;

    public int solve(int A) {
        return sum(A);

    }

    private int sum(int A) {
        if (A == 1) {
            return 1;
        }

        return A % 10 + sum(A / 10);

        // return A % 10;
    }

    public static void main(String[] args) {
        SumOfDigitsWithRecursion digitsWithRecursion = new SumOfDigitsWithRecursion();
        int ans = digitsWithRecursion.solve(123);
        System.out.println(ans);
    }
}
