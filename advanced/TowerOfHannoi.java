package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TowerOfHannoi {

    ArrayList<ArrayList<Integer>> orderedMoves = new ArrayList<>();

    public static void main(String[] args) {
        TowerOfHannoi hannoi = new TowerOfHannoi();
        hannoi.TOH(3, 1, 3, 2);

        // hannoi.orderedMoves.stream().map(x -> x.stream().toArray()).toArray(int[][]::new);
        hannoi.orderedMoves.stream().forEach(System.out::println);
        // for (int[] is : mat) {
        //     System.out.println(is);
        // }

    }

    private void TOH(int n, int src, int dest, int temp) {

        if (n == 0)
            return;

        TOH(n - 1, src, temp, dest);
        orderedMoves.add(new ArrayList<>(Arrays.asList(n, src, dest)));
        TOH(n - 1, temp, dest, src);

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
}
