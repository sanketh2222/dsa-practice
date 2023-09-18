import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSort {

    public int[] solve(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = getFreqMap(A);

        for (int i = 0; i < B.length; i++) {
            if (freqMap.containsKey(B[i])) {
                int freq = freqMap.get(B[i]);

                while (freq > 0) {
                    result.add(B[i]);
                    freq--;
                }
            }
            freqMap.remove(B[i]);
        }

        Iterator<Integer> it = freqMap.keySet().iterator();

        while (it.hasNext()) {
            int key = it.next();
            int freq = freqMap.get(key);

            while (freq > 0) {
                result.add(key);
                freq--;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<Integer, Integer> getFreqMap(int[] A) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            if (freqMap.containsKey(A[i])) {
                freqMap.put(A[i], freqMap.get(A[i]) + 1);
            } else {
                freqMap.put(A[i], 1);
            }
        }

        return freqMap;
    }

    public static void main(String[] args) {
        int[] A = {12,7};
        int[] B = {7,1,6,17,2,19,10};
        RelativeSort relativeSort = new RelativeSort();
        Arrays.toString(relativeSort.solve(A, B));

        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = j++; //ans 0
            j = ++j; //ans 10
        }
        System.out.println(j);
    }
}
