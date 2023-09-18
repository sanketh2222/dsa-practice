package revision;

public class MatrixMedian {

    public int findMedian(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int medianPos = ( (rowSize * colSize) + 1 ) / 2;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high) {

            int mid = (low + high) / 2;

            int count = 0;

            for (int i = 0; i < A.length; i++) {
                int x = findCount(A[i] , mid);
                
                while (x < A[0].length && A[i][x] == mid) {
                    x += 1;
                }

                count += x;
            }

            if (count < medianPos) {
                low = mid + 1;  
            
            } else {
                high = mid;
            }

        }

        return low ;
    }

    private int findCount(int[] arr , int k) {
        int low = 0, high = arr.length - 1;
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid]  == k) {
                return mid;
            
            } else if (arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };
        MatrixMedian matrixMedian = new MatrixMedian();
        matrixMedian.findMedian(matrix);
        System.out.println("done");
    }
}
