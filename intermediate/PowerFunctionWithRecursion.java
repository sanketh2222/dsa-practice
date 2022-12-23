public class PowerFunctionWithRecursion {

    public static int pow(int A, int B, int C) {
        if (B == 0 && C != 0)
            return (1 % C);
        if (B == 0)
            return 1;

        int halfPower = pow(A, B / 2, C);

        // Below can be a pull answer if B is even, in case of odd power
        // it can be considered as partial answer which needs to be multipled by A
        int halfAns = (int) ((long) (halfPower % C) * halfPower % C) % C;
        if (B % 2 == 0) {
            return halfAns;
        }
        if (A < 0)
            return (A % C) * (halfAns % C) + C;
        return (int) ((long) (A % C) * halfAns % C);
    }

    public static int powPrac(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 1 && A > 0)
            return A;
        if (B == 0)
            return 1;

        int halfPower = pow(A, B / 2, C); // A ^ N/2
        int halfAns1 = (int) ((long) (halfPower % C) * halfPower % C) % C;
        int halfAns =  (int) ((long) (halfPower % C) * (halfPower % C)) % C;

        if (halfAns < 0)
            return (halfAns % C) + C;

        if (B % 2 == 0)
            return halfAns;
        else if (A < 0)
            return (int) ((long) ((A % C) + C) * halfAns % C);
        else
            return (int) ((long) (A % C) * halfAns % C);
    }

    public static void main(String[] args) {
        // int ans = PowerFunctionWithRecursion.pow(2, 8, 16);
        // System.out.println(ans);
        // System.out.println(-1 % 20);
        int ans1 = PowerFunctionWithRecursion.powPrac(-1, 1, 20);
        System.out.println(ans1);
        

    }
}
