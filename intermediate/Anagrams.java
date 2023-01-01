import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    //Brute force
    public int solve(String A, String B) {
        Map<Character, Integer> fMap = new HashMap<>();
        for (char ch : A.toCharArray()) {
            if (fMap.containsKey(ch)) {
                int freq = fMap.get(ch);
                fMap.put(ch, ++freq);
            } else {
                fMap.put(ch, 1);

            }

        }

        for (char ch : B.toCharArray()) {
            if (fMap.containsKey(ch)) {
                int freq = fMap.get(ch);
                fMap.put(ch, ++freq);
            } else {
                fMap.put(ch, 1);

            }
        }

        return fMap.values().stream().anyMatch(x -> (x & 1) == 1) ? 0 : 1;

    }

    //Optimized approach
    public int checkAnagram(String A,String B) {
        int[] arr = new int[26];

        for (char ch : A.toCharArray()) {
            int charIndex = ch -'0' - 49;
            int freq = arr[charIndex];
            arr[charIndex] = ++freq;

        }

        for (char ch : B.toCharArray()) {
            int charIndex = ch -'0' - 49;
            int freq = arr[charIndex];
            if (freq == 0)
                return 0;
            arr[charIndex] = --freq;

        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        String A = "cat";
        String B = "bat";
        Anagrams anagrams = new Anagrams();
        int ans = anagrams.checkAnagram(A, B);
        System.out.println(ans);

        int[] arr = new int[26];
        char ch = 'a';
        char z = 'z';
        System.out.println(ch -'0' - 49);
        System.out.println(z -'0' - 49);

    }
}
