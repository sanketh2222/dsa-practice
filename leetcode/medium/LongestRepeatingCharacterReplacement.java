package leetcode.medium;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // Array to store the count of each character in the current window
        int maxCount = 0;  // Maximum frequency of any character in the current window
        int maxLength = 0;  // Maximum length of the substring found
        int left = 0;  // Left pointer of the window
        
        for (int right = 0; right < s.length(); right++) {
            // Increment the count of the current character
            count[s.charAt(right) - 'A']++;
            // Update the maximum frequency of any character in the current window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            
            // Check if the window is valid
            if (right - left + 1 - maxCount > k) {
                // If the window is not valid, decrement the count of the character at the left pointer
                count[s.charAt(left) - 'A']--;
                // Move the left pointer to the right
                left++;
            }
            
            // Update the maximum length of the substring found
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        int result = solution.characterReplacement(s, k);
        System.out.println("Maximum length of substring with at most " + k + " replacements: " + result);
    }
    
}
