package maths;


public class PrimeSum {

    public int[] primesum(int A) {
        int[] ans = {2,2};
        // if (A == 10)
        //     return new int[]{3,7};
        // if (A == 184)
        //     return new int[]{3,181};

        // return ans;
        int num1 = 2;
        A-=2;
        while (!isPrime(A) || !isPrime(num1)) {
            A-=1;
            num1+=1;
        }

        ans[0] = num1;
        ans[1] = A;

        return ans;
    }

    private boolean isPrime(int n){
        int count = 0;
        for (int i = 1; i * i <= n ; i++) {
            if (n % i == 0) { count += 2;}
            if (i * i == n) { count += 1;}
        }

        if (count == 2)
            return true;      

        return false;
    }
    
    public static void main(String[] args) {
        PrimeSum primeSum = new PrimeSum();
        int[] ans = primeSum.primesum(10);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        System.out.println(primeSum.isPrime(8));
    }
}
