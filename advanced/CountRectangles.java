package advanced;

import java.util.HashSet;
import java.util.Set;

public class CountRectangles {

    private Set<String> points = new HashSet<>();

    public int solve(int[] A, int[] B) {
        int count = 0;

        for (int i = 0; i < B.length; i++) {
            String point = A[i] + "," + B[i];
            points.add(point);

        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < B.length; j++) {
                if (A[i] != A[j] && B[i] != B[j]) {// check if points are diagonal
                    String point1 = A[i] + "," + B[j];
                    String point2 = A[j] + "," + B[i];
                    if (points.contains(point1) && points.contains(point2))
                        count += 1;

                }
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        CountRectangles countRectangles = new CountRectangles();
        int[] x = { 1, 1, 2, 2, 3, 3 };
        int[] y = { 1, 2, 1, 2, 1, 2 };
        int ans = countRectangles.solve(x, y);
        System.out.println(ans);

    }
}
