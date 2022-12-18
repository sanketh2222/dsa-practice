package advanced;

public class NumberOf1Bit {

    public int numSetBits(int A) {
        int count = 0;
        for (int i = 0 ; i < 32 ; i++){
            if (checkBit(A,i))
                count+=1;
        }

        return count;
    }

    private boolean checkBit(int n,int pos){
        int val = n & (1 << pos);//possible mistake int val = (n & 1) << pos;
        if (val == 0)//possible mistake val != 1
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
