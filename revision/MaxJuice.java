package revision;

public class MaxJuice {

    public int solve(int[] A, int B) {
        int maxGlassNo = 0;
        int totalJuice = B;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= totalJuice) {
                maxGlassNo += 1;
                totalJuice -= A[i];
            }

            if (totalJuice <= 0) {
                break;
            }
        }
        int maxGlassNoRev = 0;
        totalJuice = B;
        for (int j = A.length - 1; j >= 0; j--) {

            if (A[j] <= totalJuice) {
                maxGlassNoRev += 1;
                totalJuice -= A[j];
            }

            if (totalJuice <= 0) {
                break;
            }
        }

        return (int) Math.max(maxGlassNo, maxGlassNoRev);
    }

    public static void main(String[] args) {
        MaxJuice juice = new MaxJuice();
        int[] A= {1,2,3};
        int B = 3;
        System.out.println(juice.solve(A, B));
    }
}
