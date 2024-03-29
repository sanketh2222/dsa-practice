public class isAlpha {

    public int solve(char[] A) {
        for (char c : A) {
            if (!((c >= 48 && c <= 57) || (c >= 65  && c <= 90) || (c >= 97 && c <= 122)))
                return 0;
        }
        return 1;
    }
    
    public static void main(String[] args) {
        isAlpha alpha = new isAlpha();
        char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(alpha.solve(arr));
    }
}
