package advanced;

public class ReverseString {

    public String solve(String A) {
        // char[] ch = A.trim().toCharArray();
        int n = A.length() - 1;
        StringBuffer ans = new StringBuffer();
        StringBuffer curr = new StringBuffer();

        for (int i = n; i >= 0; i--) {
            if (A.charAt(i) != ' ') {
                curr.append(A.charAt(i));
            } else {
                ans.append(" ");
                ans.append(reverseString(curr.toString()));
                curr.setLength(0);
            }
        }
        ans.append(" ");
        ans.append(reverseString(curr.toString()));
        return ans.toString().trim();
    }

    public String reverseString(String A) {
        char[] ch = A.toCharArray();
        int start = 0, end = ch.length - 1;

        while (start < end) {
            swap(start, end, ch);
            start++;
            end--;
        }
        return new String(ch);

        // return null;
    }

    private void swap(int i, int j, char[] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv"));

    }
}
