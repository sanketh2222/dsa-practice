public class PowerWithModule {

    public static int solve(int A, int B, int C) {
        int ans = 1;
        for (int i = 0; i < B; i++) {
            if (A > 0)
                ans = (int) ((long) (ans % C) * A % C);
            else
                ans = (int) ((long) (ans % C) * (A + C) % C);
        }

        return ans;
    }

    public static void main(String[] args) {
        int ans = PowerWithModule.solve(-1, 1, 20);
        System.out.println(ans);
    }
}
