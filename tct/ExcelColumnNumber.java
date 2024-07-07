public class ExcelColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            // result = result * 26 + (ch - 'A' + 1);
            result = result + (int) Math.pow(26, columnTitle.length() - i - 1) * (ch - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String columnTitle = "ZA";
        int result = titleToNumber(columnTitle);
        System.out.println("The column number for " + columnTitle + " is: " + result);
    }
}
