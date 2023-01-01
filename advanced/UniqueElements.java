package advanced;

import java.util.HashMap;
import java.util.Map;

public class UniqueElements {
    public int solve(int[] A) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            if (!map.containsKey(i)){
                map.put(i, count);
                continue;
            }
            

            while (map.containsKey(i)){
                count +=1;
                i +=1;
            }
            map.put(i , count);
        }

        return count;
    }

    public static void main(String[] args) {
        UniqueElements elements = new UniqueElements();
        int[] arr = { 51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62 };
        int ans = elements.solve(arr);
        System.out.println(ans);
        
    }
}
