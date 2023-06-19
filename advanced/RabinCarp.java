

public class RabinCarp {

    //Brute force
    public int solve(String A, String B) {
        int count = 0;
        for (int i = 0; i < A.length() - B.length() + 1; i++) {
            String str = A.substring(i, i + B.length());
            if (str.equals(B))
                count += 1;

        }
        return count;
    }

    public static void main(String[] args) {
        RabinCarp carp = new RabinCarp();
        String A = "acbdccdbcadaba";
        String B = "a";
        System.out.println(carp.solve(A, B));

    }
}
