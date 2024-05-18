package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {

        int result = 0, prev = 0;
        Map<Character, Integer> romanMp = getRomanData();
        for (char ch : s.toCharArray()) {
            int currVal = romanMp.get(ch);

            if (currVal > prev) {
                result += (currVal - 2 * prev);
            } else {
                result += currVal;
            }

            prev = currVal;
        }

        return result;

    }

    private Map<Character, Integer> getRomanData() {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        return mp;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String s = "MCMXCIV";
        System.out.println(romanToInt.romanToInt(s));
        // for example IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900
        // so if we see a smaller value before a larger value, we subtract the smaller
        // value from the larger value
        // else we add the value
        // Take an example of IV = 4
        // I = 1, V = 5
        // V is greater than I, so we add 5
        // but we subtract 1 from 5, so 5 - 1 = 4
        // so the result is 4
    }
}
