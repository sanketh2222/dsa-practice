package maths;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfDivisors {

    public int[] solve(int[] A) {
        // int[] spf = new int[A.length + 1];
        List<Integer> spf = new ArrayList<Integer>();

        spf.add(0);
        spf.add(0);

        for (int i = 0; i < A.length; i++) {
            spf.add(A[i]);
        }

        for (int i = 2; i * i <= A.length; i++) {
            if (spf.get(i) == i) {

                for (int j = i * i; j <= A.length; j += i) {
                    spf.set(j, Math.min(spf.get(j), i));
                }
            }
        }

        return spf.stream().filter(x -> x > 1).mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        CountOfDivisors countOfDivisors = new CountOfDivisors();
        int[] spf = countOfDivisors.solve(arr);
        Arrays.stream(spf).forEach(System.out::print);
    }
}
