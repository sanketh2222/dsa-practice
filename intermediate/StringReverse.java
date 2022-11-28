public class StringReverse {

    public String solve(String A) {
        int start = 0, end = A.length() - 1;
        StringBuffer buffer = new StringBuffer(A);
        while (start < end) {
            char a = A.charAt(start);
            char b = A.charAt(end);

            buffer.setCharAt(start, b);
            buffer.setCharAt(end, a);
            start++;
            end--;

        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String A = "scaler";
        StringReverse reverse = new StringReverse();
        String ans = reverse.solve(A);
        System.out.println(ans);
    }
}
