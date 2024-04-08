package arrays;
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] A) {
        String ans = A[0];
        StringBuilder temp = new StringBuilder();

        for (int i = 1; i < A.length; i++) {
            char[] str1 = ans.toCharArray();
            char[] str2 = A[i].toCharArray();
            int j = 0;
            while (j < str1.length && j < str2.length) {
                if (str1[j] == str2[j]) {
                    temp.append(str1[j]);
                    j++;
                } else {
                    break;
                }
            }
            ans = temp.toString();
            temp.setLength(0);

        }

        return ans;
    }

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] arr = { "abab", "ab", "abcd" };
        String ans = commonPrefix.longestCommonPrefix(arr);
        System.out.println(ans);

    }
}
