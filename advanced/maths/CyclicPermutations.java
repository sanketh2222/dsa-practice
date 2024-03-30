package maths;


public class CyclicPermutations {

    public int solve(String A, String B) {
        String txt = A + "$" + B + B;
        int ans = createLPS(txt.length(), txt, A.length());
        return ans;
    }

    public int createLPS(int n, String str, int patternSize) {
        int[] lps = new int[n];
        lps[0] = 0;
        int totalCount = 0;
        for (int i = 1; i < n - 1; i++) {
            int x = lps[i - 1];

            while (str.charAt(x) != str.charAt(i)) {

                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];

            }
            if ((x + 1) == patternSize) {
                totalCount += 1;
            }
            lps[i] = x + 1;
        }
        return totalCount;

    }

    public static void main(String[] args) {
        CyclicPermutations cyclicPermutations = new CyclicPermutations();
        String A = "111";
        String B = "111";

        int ans = cyclicPermutations.solve(A, B);
        System.out.println(ans);

    }
}
