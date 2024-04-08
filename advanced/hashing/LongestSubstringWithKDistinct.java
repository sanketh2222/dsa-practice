package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {
    public static int solve(String A, int B) {
        Map<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;
        if (B == 0) { return 0; }
        
        int right = 0;
        int left = 0;
        while (right < A.length()) {
            char newChar = A.charAt(right);
            mp.put(newChar, mp.getOrDefault(newChar, 0) + 1);

            while (mp.size() > B) {
                char prevChar = A.charAt(left);
                mp.put(prevChar, mp.get(prevChar) - 1);

                if (mp.get(prevChar) == 0) {
                    mp.remove(prevChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right += 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(solve("cadbecbda", 2));
        // System.out.println(solve("araaci", 1));
        // System.out.println(solve("cbbebi", 3));
    }
}
