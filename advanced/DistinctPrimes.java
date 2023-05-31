

import java.util.Arrays;

public class DistinctPrimes {

    public int solve(int[] A) {
        long value = Arrays.stream(A).reduce(1,(a,b) -> a * b);

        return countDivisors(value);

    }


    private long spf(Long n) {
        // if divisible by 2
        if (n % 2 == 0)
            return 2;

        // iterate from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return i;
        }

        return n;
    }

    private int countDivisors(Long n) {
       
        // int divisors = 1;
        int count  = 0;
        
        while( n > 1){
            Long divisor = spf(n);
            while(n % divisor == 0){
                n = n / divisor;
                // count += 1;
            }
            count+=1;
            // divisors *= (count + 1);
        }

        return count;    
    }
    
    public static void main(String[] args) {
        DistinctPrimes distinctPrimes = new DistinctPrimes();
        int[] arr = { 63, 52, 28, 72, 9, 62, 79, 71, 43, 15, 82, 21, 10, 12, 38, 96, 58, 99, 59, 100, 10, 38, 92, 30, 24, 3, 49, 17, 2, 63, 54, 18, 71, 7, 65, 87, 82, 31, 48, 39, 100, 82, 15, 60, 44, 84, 43, 5, 63, 17, 100, 94, 62, 26, 35, 29};
        int ans = distinctPrimes.solve(arr);
        System.out.println(ans);
    }
}
