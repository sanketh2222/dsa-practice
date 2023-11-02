package revision;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring with non repeating characters
 * Strivers video <a href ="https://youtube.com">
 */
public class LongestSubstringWithUniqueChars {

    /**
     * Longest substring with non repeating characters
     * Strivers video
     * <a href ="https://www.youtube.com/watch?v=qtVh-XEpsJo&t=1052s">
     */
    public static int lengthOfLongestSubstring(String A) {
        int n = A.length();
        Map<Character, Integer> mp = new HashMap<>();// character , index of occurence
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            char newChar = A.charAt(right);

            if (mp.containsKey(newChar)) {
                left = Math.max(left, mp.get(newChar) + 1);
                // remember that when we more left towards the next index of prev occurence we
                // are not deleting the occurences of characters before the current left
                // <a href ="">
            }

            ans = Math.max(ans, right - left + 1);
            mp.put(newChar, right);
            right += 1;

        }

        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("anc");
    }
}
