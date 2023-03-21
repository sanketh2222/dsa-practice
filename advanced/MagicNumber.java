package advanced;

public class MagicNumber {
    private int sum = 0;
    public int getSum(int A) {

        if (A == 0)
            return 0;

        sum += A % 10;
        A = A /10;
        getSum(A);

        return sum;
    }
    
    public static void main(String[] args) {
        MagicNumber magicNumber = new MagicNumber();
        // System.out.println();
        int ans =  magicNumber.getSum(83557);
        while (ans > 9) {
            magicNumber.sum = 0;
            ans = magicNumber.getSum(ans);
        //    System.out.println(ans);
        }

        System.out.println(ans);
        
    }
}
