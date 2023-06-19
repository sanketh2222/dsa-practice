

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> currList = new ArrayList<>();
        Collections.sort(A);
        generateSubsets(0, currList, A.size(), A);

        Collections.sort(ans, (first, second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
                // return (first.get(i) - second.get(i));
            }
            return (first.size() - second.size());
        });

        ans.forEach(x -> {
            System.out.println();
            System.out.print("[");
            x.forEach(y -> System.out.print(y + ","));
            System.out.print("]");
        });

        return ans;
    }

    private void generateSubsets(int idx, List<Integer> currList, int n, ArrayList<Integer> arr) {
        if (idx == n) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        currList.add(arr.get(idx));
        generateSubsets(idx + 1, currList, n, arr);
        currList.remove(arr.get(idx));
        generateSubsets(idx + 1, currList, n, arr);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new ArrayList<>(List.of(1, 2, 3)));
        // ans.forEach(x -> {
        // System.out.println();
        // System.out.print("[");
        // x.forEach(y -> System.out.print(y + ","));
        // System.out.print("]");
        // });
        // System.out.println(ans.size());

    }
}
