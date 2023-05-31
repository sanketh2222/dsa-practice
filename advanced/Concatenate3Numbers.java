

public class Concatenate3Numbers {

    public int solve(int A, int B, int C) {
        return 0;
    }

    public static int minConcat(int A, int B, int C) {
        int minFirstDigit = Math.min(Math.min(A / 10, B / 10), C / 10);
        int minSecondDigit = Math.min(Math.min(A % 10, B % 10), C % 10);
        return minFirstDigit * 100 + minSecondDigit * 10
                + Math.min(Math.min(Math.max(A, B), C) % 10, Math.max(Math.min(A, B), C) % 10);
    }

    public static void main(String[] args) {

    }
}
