

public class SpecialInteger {

    public int solve(int[] A, int B) {
        int low = 0, high = A.length;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(A, B, mid)){
                ans = mid;
                low = mid + 1;
            
            } else {
                high = mid - 1;
            } 
        }
        return ans;
    }

    private boolean check(int[] A, int target, int k) {
        int start = 0, end = k;
        int sum = 0;

        for (int i = start; i < k; i++) {
            sum += A[i];
        }

        if (sum > target)
            return false;
        
        while(end < A.length){
            sum -= A[start++];
            sum += A[end++];

            if (sum > target)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        SpecialInteger integer = new SpecialInteger();
        int[] arr = {5, 10, 20, 100, 105 };
        int ans = integer.solve(arr, 130);
        System.out.println(ans);

    }
}
