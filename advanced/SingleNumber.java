

public class SingleNumber {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        System.out.println(ans);
    }
}
