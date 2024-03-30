package recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TowerOfHannoi {

    ArrayList<ArrayList<Integer>> orderedMoves = new ArrayList<>();

    public static void main(String[] args) {
        TowerOfHannoi hannoi = new TowerOfHannoi();
        hannoi.TOH(3, 1, 3, 2); //move 3 disks from 1 to 3 using 2
        hannoi.orderedMoves.stream().forEach(System.out::println);
    }

    // TOH(n, src, dest, temp) means move n disks from src to dest using temp
    private void TOH(int n, int src, int dest, int temp) {

        if (n == 0) { return; }

        TOH(n - 1, src, temp, dest); //move n-1 disks from src to temp
        orderedMoves.add(new ArrayList<>(Arrays.asList(n, src, dest)));
        //move nth disk from src to dest
        TOH(n - 1, temp, dest, src);//move n-1 disks from temp to dest

    }

    private static int[][] test() {
        List<List<Integer>> newLst = new ArrayList<>();
        newLst.add(List.of(1, 1, 3));
        newLst.add(List.of(3, 2, 1));

        newLst.stream().flatMap(List::stream).collect(Collectors.toList());

        int[][] mat = newLst.stream().map(x -> x.stream().toArray()).toArray(int[][]::new);

        return mat;
    }
}
