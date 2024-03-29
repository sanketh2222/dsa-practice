
public class SingleNumber {

    // Question: https://www.interviewbit.com/problems/single-number/
    // Given an array of integers, every element appears twice except for one. Find
    // that single one.
    // Leetcode: https://leetcode.com/problems/single-number/
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        System.out.println(ans);
    }
}
