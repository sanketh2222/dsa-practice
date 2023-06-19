

public class SquareRoot {

    public int sqrt(int A) {
        long low = 1, high = A;

        long mid = (high - low) / 2 + low;

        while (low <= high) {
            mid = (high - low) / 2 + low;

            if (mid * mid == A)
                return (int) mid;
            else if (mid * mid > A) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return mid * mid > A ? (int) mid - 1 : (int) mid;
        // return mid;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().sqrt(2147483647));
    }

}
/**
 * Licensed to the Sanketh Foundation (SF) under one
 * 
 **/
