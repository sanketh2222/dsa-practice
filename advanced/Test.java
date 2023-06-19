

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Test {

        public static void main(String[] args) throws CloneNotSupportedException {
                int[] B = { 14, 12, 7, 7, 18, 13, 6, 18, 1, 33, 4, 7, 11, 16, 27, 9, 4, 8, 25, 25, 11, 34, 21, 6, 20, 1,
                                4, 16,
                                19 };
                int[] C = { 18, 8, 9, 11, 6, 4, 17, 7, 3, 1, 2, 13, 19, 4, 20, 8, 6, 1, 13, 1, 2, 25, 25, 11, 1, 23, 14,
                                18,
                                19 };
                int[] D = { 18, 35, 11, 12, 30, 39, 40, 19, 3, 37, 37, 44, 43, 30, 29, 17, 37, 29, 34, 41, 14, 38, 45,
                                30, 41,
                                24, 14, 29, 20 };
                int[] E = { 20, 19, 24, 22, 19, 4, 28, 13, 16, 9, 23, 13, 28, 21, 21, 21, 14, 18, 28, 4, 4, 27, 27, 14,
                                29, 25,
                                19, 28, 20 };

                // System.out.println(B.length);
                // System.out.println(C.length);
                // System.out.println(D.length);
                // System.out.println(E.length);

                List<Integer> list = Arrays.asList(100, 100, 100, 1);
                // list.set(0, 2);

                int ans = list.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
                int sum = list.stream().reduce(0, (a, b) -> (a + b) / 2);
                int minValue = list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
                // System.out.println(minValue);

                // list.forEach(System.out::println);
                // System.out.println(sum);

                double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);

                // System.out.println(avg);
                int[] arr = { 2, 2, 2, 2, 8, 2, 2, 2, 10 };
                Integer[] s = Arrays.stream(arr).distinct().boxed().toArray(Integer[]::new);
                int[] ans1 = Arrays.stream(arr).distinct().toArray();
                // int[] arr1 = Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10).stream().mapToInt(x ->
                // x).distinct().toArray();
                // https://www.baeldung.com/java-stream-reduce
                // for (int i : ans1) {
                // System.out.println(i);
                // }
                int[] arr1 = { 1, 2, 3, 4 };
                int value = Arrays.stream(arr1).reduce(1, (a, b) -> a * b);
                // System.out.println(value);

                // test();
                // System.out.println(10|10);
                // String Str = "hello";
                // Str.toCharArray().toString();
                // StringBuilder builder = new StringBuilder(Str);
                // System.out.println(builder.reverse());

                ListNode curr = createLinkedList();
                ListNode nexNode = curr;
                // ListNode temNode = curr.clone();
                // curr.next = null; // has effect on next node
                curr = curr.next; //no effect on next node
                System.out.println(curr);
                // System.out.println(temNode);
                // System.out.println(nexNode);
                // // Arrays.sort(args);

                Queue<Integer> queue = new LinkedList<Integer>();
        }

        private static int[][] test() {
                List<List<Integer>> newLst = new ArrayList<>();
                newLst.add(List.of(1, 1, 3));
                newLst.add(List.of(3, 2, 1));

                newLst.stream().flatMap(List::stream).collect(Collectors.toList());

                // newLst.stream().forEach(System.out::println);
                int[][] mat = newLst.stream().map(x -> x.stream().toArray()).toArray(int[][]::new);

                return mat;
        }

        private static ListNode createLinkedList() {
                ListNode node1 = new ListNode(1);
                ListNode node2 = new ListNode(2);
                ListNode node3 = new ListNode(3);

                node1.next = node2;
                node2.next = node3;
                node3.next = null;
                return node1;
        }
}
