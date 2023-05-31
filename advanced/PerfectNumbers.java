

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class PerfectNumbers {

    public String solve(int A) {
        Queue<Long> queue = new ArrayDeque<>();

        queue.add(1L);
        queue.add(2L);

        while (A > 1) {
            Long ele = queue.remove();
            Long ele1 = ele * 10 + 1;
            Long ele2 = ele * 10 + 2;
            queue.add(ele1);
            queue.add(ele2);
            A--;
        }

        StringBuilder sb = new StringBuilder(queue.peek().toString());

        return queue.peek().toString().concat(sb.reverse().toString());
    }

    public static void main(String[] args) {
        PerfectNumbers numbers = new PerfectNumbers();
        System.out.println(numbers.solve(100000));// 3 -> 4

    }
}
