

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class FirstNonRepeatingProblem {

    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        StringBuffer ans = new StringBuffer();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            freqMap.put(A.charAt(i), freqMap.getOrDefault(A.charAt(i), 0) + 1);
            queue.offer(A.charAt(i));

            // ensure that the front end of the queue has character with freq 1
            while (!queue.isEmpty()) {

                if (freqMap.get(queue.peek()) > 1) {
                    queue.poll();

                } else {
                    ans.append(queue.peek());
                    break;
                }
            }

            if (queue.isEmpty()) {
                ans.append('#');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) throws ParseException {
        FirstNonRepeatingProblem firstNonRepeatingProblem = new FirstNonRepeatingProblem();
        System.out.println(firstNonRepeatingProblem.solve("abba"));
      
       
    }
}
