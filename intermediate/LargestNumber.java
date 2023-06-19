import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public class SortByFirstDigit implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            int firstDigitFirstNum = getFirstDigit(o1.intValue());
            int firstDigitSecNum = getFirstDigit(o2.intValue());
            if (firstDigitFirstNum > firstDigitSecNum) {
            }
            return 0;
        }

    }

    private int getFirstDigit(int n) {
        int lastDigit = 0;
        while (n != 0) {
            lastDigit = n % 10;
            n = n / 10;
        }
        return lastDigit;
    }

    public String largestNumber(final int[] A) {
        // we need to copy the elements to another array because its final we can't
        // modifiy it.
        Integer arr[] = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }
        // create a new comparator to compare the elements
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String x = String.valueOf(a) + String.valueOf(b);
                String y = String.valueOf(b) + String.valueOf(a);
                return y.compareTo(x);
            }
        });
        // edge case to check
        if (arr[0] == 0) {
            return "0";
        }
        // we need to return it as a string so create a StringBuilder because we need to
        // convert Integer to String.
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        // System.out.println(arr.toString());
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(Arrays.toString(arr[i]));
        }
        // char ch = 'A';
        // ch ^= 32;
        String str = "abcd";
        // str[0] = "d";

        for (char ch : str.toCharArray()) {
            ch ^= 32;
        }
        System.out.println(str);
        Arrays.sort(str.toCharArray());
        System.out.println("11".compareTo("12"));
        System.out.println("12".compareTo("11"));

    }
}
