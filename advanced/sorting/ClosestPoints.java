package sorting;

import java.util.Arrays;

public class ClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        // Custom comparator to compare points based on squared distance from origin
        // Arrays.sort(points, (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] +
        // a[1] * a[1]));
        Arrays.sort(points, (a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }
    public static void main(String[] args) {
        ClosestPoints closestPoints = new ClosestPoints();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        int[][] result = closestPoints.kClosest(points, k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }

        //Arrays.copyOfRange(points, 0, k); doesnt affect the original sorted array
        //it copies the elements as it is ignoring the sorting
    }
        
    

}
