package arrays;

public class JosephusProblem {

    // Given the total number of persons n and a number k which indicates that k-1
    // persons are skipped and kth person is killed in circle in a fixed direction.
    // The task is to choose the safe place in the circle so that when you perform
    // these operations starting from 1st place in the circle, you are the last
    // remaining person and survive.
    // For example, if n = 5 and k = 2, the safe position is 3.
    // Initially, the safe position is 0. So, we add k to the safe position and
    // take the modulo of the sum with the current number of persons. We repeat this
    // process until the number of persons is 1.

    public static int josephus(int n, int k) {
        int safePosition = 0;
        for (int i = 1; i <= n; i++) {
            safePosition = (safePosition + k) % i; 
            // why % i instead of n?
            // because the number of persons is decreasing by 1 each time

        }
        return safePosition + 1;
    }

    //recursive solution
    public static int josephusRecursive(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephusRecursive(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int A = 8;
        int closestPower = 1;
        int n = 1;
        while (n < A) {
            n = n * 2;
            if (n < A) {
                closestPower = n;
            }

        }
        System.out.println(closestPower);
        int ans = 0;
        int kill = (A - closestPower);
        ans = 1 + (2 * kill);

        // return ans;
        main();

    }




    public static void main() {
        JosephusProblem.josephus(5, 2);
    }

}
