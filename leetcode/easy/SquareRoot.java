package easy;

public class SquareRoot {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long low = 0, high = x;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        int x = 3;
        System.out.println(sr.mySqrt(x));
    }
}
