package advanced;

public class MaxAbsoluteDifference {
    
    public static int maxArr(int[] A) {
        int epx1MaxValue = Integer.MIN_VALUE, epx2MaxValue = Integer.MIN_VALUE; 
        int epx1MinValue = Integer.MAX_VALUE, epx2MinValue = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++){
           epx1MaxValue =  Math.max(A[i] + i , epx1MaxValue);
           epx2MinValue =  Math.min(A[i] - i , epx2MinValue);

           epx1MinValue = Math.min(A[i] + i , epx1MinValue);
           epx2MaxValue = Math.max(A[i] - i , epx2MaxValue);
        }

        // return Math.max(epx1MaxValue - epx2MinValue, epx2MaxValue - epx1MinValue);
        return Math.max(epx2MaxValue - epx2MinValue, epx1MaxValue - epx1MinValue);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1};
        int ans = MaxAbsoluteDifference.maxArr(arr);
        System.out.println(ans);
        
    }
}
