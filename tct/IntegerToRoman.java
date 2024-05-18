public class IntegerToRoman {

    private final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    //TC: O(1), SC: O(num)
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        convertToRoman(num , ans);
        return ans.toString();
    }

    private void convertToRoman(int num , StringBuilder ans) {
        if (num <= 0) { return ;}

        int idx = getIndex(num);
        String symbol = symbols[idx];
        ans.append(symbol);
        convertToRoman(num - values[idx] , ans);
    }

    private int getIndex(int num) {
        for (int i = 0; i < values.length; i++) {
            if ( num >= values[i] ) { return i; }
        }
        return 0;

    }
    
}
