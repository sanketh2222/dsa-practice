package arrays;

import java.util.*;

/**
 * InnerLargestNumber
 */
class LargestNumberSorter implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        String order1 = String.valueOf(o1) + String.valueOf(o2);
        String order2 = String.valueOf(o2) + String.valueOf(o1);
        // Reverse order because we want a descending order
        return order2.compareTo(order1);
    }

}

public class LargestNumber {

    public static void test (Integer[] arr) {

    }

    public static void main(String[] args) {
        Integer[] arr = { 8 ,89 };
        Arrays.sort(arr, new LargestNumberSorter());
        System.out.println(Arrays.toString(arr));
        int[] p = {1,2};
        Integer[] n = Arrays.stream(p).boxed().toArray(Integer[]::new);
    }

}
