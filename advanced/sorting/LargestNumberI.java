package sorting;

import java.util.Arrays;

public class LargestNumberI {

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (Integer num1, Integer num2) -> {
            String a = String.valueOf(num1);
            String b = String.valueOf(num2);

            return (b + a).compareTo(a + b);
        });

        StringBuilder sb = new StringBuilder();

        for (int num : arr) {
            sb.append(String.valueOf(num));
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();

    }
}
