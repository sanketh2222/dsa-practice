package hashing;

import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * longest substring without repeating characters
 */
public class LongestSubstringWithUnique {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            ans = Math.max(ans, right - left + 1);

            right += 1;

        }

        return ans;
    }
}
