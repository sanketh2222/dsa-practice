package test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestTest implements TestC {

    public class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

    }

    public void testDijkstras() {
        Queue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
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
        Collections.sort(A, (a, b) -> {
            int c = a % 10;
            int d = b % 10;

            if (c == b)
                return b - a;
            else
                return c - d;
        });

        return A;
    }

    public int maxProfit(final int[] A) {

        if (A.length == 0) {
            return 0;
        }
        int buyPrice = A[0];
        int sellPrice = A[0];
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < buyPrice) {
                buyPrice = A[i];
                sellPrice = 0;
            }

            maxProfit = Math.max(maxProfit, sellPrice - buyPrice);

        }

        return maxProfit;
    }

    public int findMin(int[] A) {
        int low = 0, high = A.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] <= A[0]) {
                ans = Math.min(ans, A[mid]);
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return ans == Integer.MAX_VALUE ? A[0] : ans;
    }

    public static void main(String[] args) throws ParseException {
        TestTest T = new TestTest();
        T.test();
        System.out.println(T.isFromDateGreaterThanToDate("01-01-2021", "01-01-2020"));
        // int a = 20;
        // T.test1(a);
        System.out.println(a);
        String fromDate = "01-01-2021";
        String toDate = "01-02-2021";
        System.out.println(printDates(fromDate, toDate));
        System.out.println("27AAKPB0593M1ZH".substring(0, 2));
        System.out.println(new BigDecimal("3").add(new BigDecimal("3")));
        T.testDijkstras();
        List<List<Integer>> lst = new ArrayList<>();
        // int[][] dp = lst.toArray(new int[lst.get(a).size()][lst.size()]);
        List<Integer> integers = new ArrayList<>();
        integers.removeIf(x -> x == 1);
        T.maxProfit(new int[] { 1, 2 });
        T.findMin(new int[] { -1, 2, 3 });
        String str = "sank";
        int a1 = str.charAt(1);
        System.out.println(a1);
        lst.stream().flatMapToInt(x -> x.stream().mapToInt(Integer::intValue)).toArray();
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9));

        int[] flattenedArray = listOfLists.stream()
                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                .toArray();

        IntStream st = listOfLists.stream()
                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue));
        
        IntStream.range(0, 1).toArray();
        int a = 3;
        int b = 30;
        String aa = String.valueOf(a) + String.valueOf(b);
        String bb = String.valueOf(b) + String.valueOf(a);
        System.out.println(aa.compareTo(bb));
        System.out.println(bb.compareTo(aa));

    }

}
