package revision;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String A) {
        String ans = "";
        for (int i = 0; i < A.length(); i++) {
            // odd palindrome
            // ans = Math.max(ans, getPalindromeLength(A,i,i));
            String palindrome = getPalindromeLength(A, i, i);

            if (palindrome.length() > ans.length()) {
                ans = palindrome;
            }

            palindrome = getPalindromeLength(A, i, i + 1);
            if (palindrome.length() > ans.length()) {
                ans = palindrome;
            }

            // ans = Math.max(ans,getPalindromeLength(A,i,i+1));
        }
        return ans;
    }

    private String getPalindromeLength(String A, int firstStartEndex, int secondStartIndex) {
        int i = firstStartEndex;
        int j = secondStartIndex;

        while (i >= 0 && j < A.length()) {
            if (A.charAt(i) == A.charAt(j)) {
                i--;
                j++;
            } else {

                break;
            }
        }
        i++;
        j--;
        return A.substring(i, j + 1);
    }

    public static void main(String[] args) {

    }
}
