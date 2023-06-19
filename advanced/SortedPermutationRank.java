

public class SortedPermutationRank {

    int mod = 1000003;

    public int findRank(String A) {
        int rank = 1;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            int x = countChars(A.charAt(i), i, A);
            int fact = fact(n - 1 - i);
            rank = (int) ((rank % mod) + (((long) x % mod * fact % mod) % mod) % mod) % mod;
        }

        return rank;

    }

    private int countChars(char ch, int start, String str) {
        int count = 0;
        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) < ch)
                count += 1;
        }

        return count;
    }

    private int fact(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact % mod * i % mod) % mod;
        }
        return fact;
    }

    public static void main(String[] args) {
        SortedPermutationRank permutationRank = new SortedPermutationRank();
        String str = "DTNGJPURFHYEW";
        System.out.println(permutationRank.findRank(str));

    }
}
