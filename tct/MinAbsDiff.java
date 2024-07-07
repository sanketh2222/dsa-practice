import java.util.TreeSet;

public class MinAbsDiff {
       public int solve(int[] A) {
        TreeSet<Integer> ts = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int num : A) {
            ts.add(num);
        }
        
        for (int num : A) {
            ts.remove(num);
            Integer ceiling = ts.ceiling(num);
            if (ceiling == null) {
                ts.add(num);
                continue;
            }
            int possibleAns = Math.abs( ( num - ceiling ) == 0 ? Integer.MAX_VALUE : (num - ceiling));
            ans = Math.min(possibleAns , ans);
            ts.add(num);
        }
        
        return ans;
        
    }

    public static void main(String[] args) {
        MinAbsDiff mad = new MinAbsDiff();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(mad.solve(A));
    }
}
