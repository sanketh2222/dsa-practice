import java.util.Arrays;

public class LeapYear {
    public boolean leapYear(int year) {
        if (year % 400 == 0)
            return true;

        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;

        // Else If a year is multiple of 4,
        // then it is a leap year
        if (year % 4 == 0)
            return true;
        return false;
    }

    public int isLeapYear(int A) {
        if (A % 400 == 0)
            return 1;

        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (A % 100 == 0)
            return 0;

        // Else If a year is multiple of 4,
        // then it is a leap year
        if (A % 4 == 0)
            return 1;
        return 0;
    }

    public int solve(int A) {
        if (A % 400 == 0 || (A % 4 == 0) || (A % 100 == 1))
            return 1;

        return 0;
    }

    public String largestNumber(final int[] A) {
        Integer[] arr = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, (x, y) -> {
            String a = String.valueOf(x) + String.valueOf(y);
            String b = String.valueOf(y) + String.valueOf(x);

            return b.compareTo(a);
        });

        if (arr[0] == 0) {
            return 0;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            ans.append(String.valueOf(arr[i]));
        }

        return ans.toString();
    }

    public int solve(int[] A) {
        int count = 0;
        int i = 0;
        while (i < A.length) {
            if (A[i] == i)
                i++;
            else {
                count++;
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
