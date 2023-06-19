

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplePrimeFactor {

    public int[] spf(int n) {
        // int[] spf = new int[A.length + 1];
        List<Integer> spf = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++) {
            spf.add(i);
        }

        for (int i = 2; i <= n; i++) {
            if (spf.get(i) == i) {

                for (int j = i * i; j <= n; j += i) {
                    spf.set(j, Math.min(spf.get(j), i));
                }
            }
        }

        return spf.stream().mapToInt(x -> x).toArray();
    }

    // private int spf(int n) {
    // // if divisible by 2
    // if (n % 2 == 0)
    // return 2;

    // // iterate from 3 to sqrt(n)
    // for (int i = 3; i * i <= n; i += 2) {
    // if (n % i == 0)
    // return i;
    // }

    // return n;
    // }

    private int[] countPrimeDivisors(int[] A) {
        int maxElement = Arrays.stream(A).reduce(1, (a, b) -> Integer.max(a, b));
        int[] spf = spf(maxElement);
        int[] ans = new int[A.length];
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            int primeDivisorCount = 0;

            while (A[i] > 1) {

                int primeDivisor = spf[A[i]];
                while (A[i] % primeDivisor == 0) {
                    A[i] = A[i] / primeDivisor;
                }
                primeDivisorCount += 1;
            }
            ans[index++] = primeDivisorCount;

        }

        return ans;
    }

    public static void main(String[] args) {
        SimplePrimeFactor factor = new SimplePrimeFactor();
        // int[] arr = {8, 9, 10};
        int[] A = { 1, 2, 3, 4};
        Set<Integer> set = new HashSet<Integer>();

        int[] ans = factor.countPrimeDivisors(A);
        for (int i = 0; i < ans.length; i++) {
            // System.out.println(ans[i]);
            set.add(Integer.valueOf(ans[i]));
        }

        int sum  = set.stream().reduce(0,(a,b) -> a + b);
        System.out.println(sum);

    }
}
