import java.util.Arrays;

public class StringConcatenation {

    public int[] findSubstring(String A, final String[] B) {

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            ans[i] = findOcc(A, B[i]);
        }

        return ans;

    }

    private int findOcc(String hayStack, String needle) {
        int n = hayStack.length() - needle.length();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (hayStack.substring(i, i + needle.length()).equals(needle)) {
                cnt += 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        StringConcatenation sc = new StringConcatenation();
        String A = "barfoothefoobarman";
        String[] B = { "foo", "bar" };
        System.out.println(Arrays.toString(sc.findSubstring(A, B)));
    }
}
