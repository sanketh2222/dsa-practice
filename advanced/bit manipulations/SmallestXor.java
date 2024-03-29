

public class SmallestXor {

    public int solve(int A, int B) {
        int ans = 0;
        int setBitCount = 0;

        for (int i = 31; i >= 0; i--) {
            if (checkBit(A, i) && B > 0) {
                ans += Math.pow(2, i);
                B--;
            }

        }

        int pos = 0;
        while (B > 0) {
            if (!checkBit(ans, pos)){
                ans += Math.pow(2, pos);
                B--;
            }
            
            pos++;
           
        }

        return ans;

    }

    private boolean checkBit(int n, int pos) {
        int val = n & (1 << pos);
        if (val == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        SmallestXor smallestXor = new SmallestXor();
        int ans = smallestXor.solve(4, 6);
        System.out.println(ans);
        System.out.println(5>>1);

    }
}
