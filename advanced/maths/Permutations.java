package maths;


import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Integer[] arr = A.toArray(new Integer[A.size()]);
        generatePermutations(0, arr.length, arr);
        return permutations;
    }

    private void generatePermutations(int start, int n, Integer[] arr) {
        if (start == n) {
            permutations.add(new ArrayList<>(Arrays.asList(arr)));
            return;
        }

        for (int i = start; i < n; i++) {
            swap(i, start,arr);
            generatePermutations(start + 1, n, arr);
            swap(i, start,arr);
        }
    }

    private void swap(int a, int b,Integer[] arr) {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new ArrayList<>(Arrays.asList(1, 2, 3)));

        permutations.permutations.forEach(x -> {
        System.out.println();
        System.out.print("[");
        x.forEach(y -> System.out.print(y + ","));
        System.out.print("]");
        });

    }
}
