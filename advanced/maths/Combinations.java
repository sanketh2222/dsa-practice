package maths;


public class Combinations {
    

    public int solve(int A, int B, int C) {
        long ans = fact(A) / (fact(A - B) * fact(B));
        return (int)ans ;
    }

    private long fact(int n){
        if (n == 0 || n == 1)
            return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        // int ans = combinations.solve(38, 5, 81);
        // int ans = combinations.fact(33);
        // System.out.println(ans);
        
    }
}
