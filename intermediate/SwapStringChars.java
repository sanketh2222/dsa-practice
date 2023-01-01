public class SwapStringChars {

    static char[] swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }
    
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(swap(str, 0, str.length() - 1));
    }
}
