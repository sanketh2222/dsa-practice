package corrected;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    private final Map<Integer, String> symbols = new HashMap<>();

    public IntegerToRoman() {
        symbols.put(1000, "M");
        symbols.put(900, "CM");
        symbols.put(500, "D");
        symbols.put(400, "CD");
        symbols.put(100, "C");
        symbols.put(90, "XC");
        symbols.put(50, "L");
        symbols.put(40, "XL");
        symbols.put(10, "X");
        symbols.put(9, "IX");
        symbols.put(5, "V");
        symbols.put(4, "IV");
        symbols.put(1, "I");
    }

    public String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder ans = new StringBuilder();
        convertToRoman(num, ans);
        return ans.toString();
    }

    private void convertToRoman(int num, StringBuilder ans) {
        if (num <= 0) {
            return;
        }

        for (Map.Entry<Integer, String> entry : symbols.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            if (num >= value) {
                ans.append(symbol);
                convertToRoman(num - value, ans);
                break;
            }
        }
    }
}
