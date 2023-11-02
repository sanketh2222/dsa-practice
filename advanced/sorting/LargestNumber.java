

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String[] args) {
        int[] arr = { 3, 30, 34, 5, 9 };
        // Arrays.stream(arr).boxed().collect(Collectors.toList());
        // Collections.sort(Arrays.stream(arr).boxed().collect(Collectors.toList()), new LargestNumberComparable());
        Arrays.stream(arr).forEach(System.out::print);
    }
}
