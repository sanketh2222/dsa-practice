

public class EnumeratingGCD {

    public String solve(String A, String B) {
        if (A.equals(B))
            return A;
        return "1";
        
    }
    
    public static void main(String[] args) {
       String A = "81991";
       String B = "2549";
       EnumeratingGCD enumeratingGCD = new EnumeratingGCD();
       String ans = enumeratingGCD.solve(A, B);
       System.out.println(ans);
        
    }
}
