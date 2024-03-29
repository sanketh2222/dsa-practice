
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        deque.push(A.get(0));
        int start = 0, end = B;

        for (int i = 1; i < B; i++) {
            while (!deque.isEmpty() && (A.get(i) > deque.peekLast())) {
                deque.removeFirst();
            }

            if (deque.isEmpty() || (A.get(i) <= deque.peekLast())) {
                deque.addLast(A.get(i));
            }
        }

        ans.add(deque.peekFirst());

        while (end < A.size()) {
            // end - B is the start element of the previous window
            if (!deque.isEmpty() && deque.peekFirst() == A.get(end - B))
                deque.removeFirst();

            while (!deque.isEmpty() && (A.get(end) > deque.peekLast())) {
                deque.removeLast();
            }

            if (deque.isEmpty() || (A.get(end) <= deque.peekLast()))
                deque.addLast(A.get(end));

            ans.add(deque.peekFirst()); // peekFirst() always gives the maximum element

            start++;
            end++;

        }

        return new ArrayList<>(ans);
    }

    private static int[][] test() {
        List<List<Integer>> tripplets = new ArrayList<>();
        Integer[][] mat = tripplets.stream().flatMap(List::stream).toArray(Integer[][]::new);
        // covert to 2d arr int[][]
        int[][] arr = tripplets.stream().flatMap(List::stream).toArray(int[][]::new);
        return arr;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        // List<Integer> ans =
        // slidingWindowMaximum.slidingMaximum(List.of(10,1,8,9,7,6,5,11,3), 3);
        // ans.forEach(System.out::println);
        // Integer i1 = 10;
        // Integer i2 = 10;
        // System.out.println(i1 == i2);
        List<List<Integer>> tripplets = new ArrayList<>();
        Integer[][] arr = tripplets.stream().flatMap(List::stream).toArray(Integer[][]::new);
    }
}
