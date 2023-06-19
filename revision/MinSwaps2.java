package revision;

public class MinSwaps2 {
       public int solve(int[] A) {
        int count = 0;
        int i = 0;
        while (i < A.length) {
            if (A[i] == i)
                i++;
            else {
                count++;
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        return count;
    }

    public void swap(int[] A, int i, int j) {
        A[i] = A[i] + A[j];
        A[j] = A[i] - A[j];
        A[i] = A[i] - A[j];
    }

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i+=2) {
            System.out.println(i);
        }
    }
}
