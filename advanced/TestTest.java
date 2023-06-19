
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestTest implements TestC {

    public class Pair {
        int node;
        int distance;


        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        
    }

    public void testDijkstras(){
        Queue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        pq.offer(new Pair(3, 10));
        pq.offer(new Pair(5, 2));

        Pair p = pq.poll();
        System.out.println(p.distance);
    }

    @Override
    public void test() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'test'");
        // TestC.a = 100;
        System.out.println(a);
    }

    private void test1(int a) {
        a += 100;
    }

    private boolean isFromDateGreaterThanToDate(String fromDate, String toDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedFromDate = LocalDate.parse(fromDate, formatter);

            LocalDate parsedToDate = LocalDate.parse(fromDate, formatter);
            // Compare the given date and time with the current date
            return parsedFromDate.isAfter(parsedToDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static List<String> printDates(String fromDate, String toDate) throws ParseException {
        List<String> retPeriodDates = new ArrayList<>();
        SimpleDateFormat fromDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat retPeriodFormat = new SimpleDateFormat("MMyyyy");

        Date currentDate = fromDateFormat.parse(fromDate);
        Date endDate = fromDateFormat.parse(toDate);

        while (currentDate.before(endDate) || currentDate.equals(endDate)) {
            String retPeriod = retPeriodFormat.format(currentDate);
            retPeriodDates.add(retPeriod);

            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.MONTH, 1);
            currentDate = cal.getTime();
        }

        return retPeriodDates;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A,(a,b)->{
            int c= a % 10;
            int d = b % 10;

            if (c == b)
                return b - a;
            else 
                return c - d;
        });

        return A;
    }

    public static void main(String[] args) throws ParseException {
        TestTest T = new TestTest();
        T.test();
        System.out.println(T.isFromDateGreaterThanToDate("01-01-2021", "01-01-2020"));
        int a = 20;
        T.test1(a);
        System.out.println(a);
        String fromDate = "01-01-2021";
        String toDate = "01-02-2021";
        System.out.println(printDates(fromDate, toDate));
        System.out.println("27AAKPB0593M1ZH".substring(0, 2));
        System.out.println(new BigDecimal("3").add(new BigDecimal("3")));
        T.testDijkstras();
     
    }

}
