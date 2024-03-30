package hashing;


import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {

    Map<Integer, Integer> map = new HashMap<>();

    public int solve(int[] A) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int possibleMinDistance = Math.abs(map.get(A[i]) - i);
                minDistance = Math.min(minDistance, possibleMinDistance);

            }

            map.put(A[i], i);
        }

        return minDistance == Integer.MAX_VALUE ? 1 : minDistance;
    }

    public static void main(String[] args) {
        ShaggyAndDistances shaggyAndDistances = new ShaggyAndDistances();
        int[] arr = {7, 1, 3, 4, 1, 7};
        System.out.println(shaggyAndDistances.solve(arr));
    }
}
