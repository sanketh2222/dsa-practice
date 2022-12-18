public class StringOperations {

    public String solve(String A) {
        StringBuffer buffer = new StringBuffer(A);


        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) >= 65 && buffer.charAt(i) <= 90) {
                buffer.deleteCharAt(i);
                i--;
            }
        }

        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == 'a' || buffer.charAt(i) == 'e' || buffer.charAt(i) == 'i'
                    || buffer.charAt(i) == 'o' || buffer.charAt(i) == 'u') {
                buffer.setCharAt(i, '#');
            }
        }

        buffer.append(buffer.toString());

        return buffer.toString();
    }

    public static void main(String[] args) {
        StringOperations operations = new StringOperations();
        String ans = operations.solve("lLdfRVCgbkND"); //ldfgbkldfgbk - ldfVgbkDldfVgbkD
        System.out.println(ans);// "bc###bc###"

    }
}
