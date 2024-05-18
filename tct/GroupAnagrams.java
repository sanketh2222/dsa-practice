
//add all the imprt statements
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public ArrayList<ArrayList<String>> getAnagrams(ArrayList<String> A) {

        Map<String, ArrayList<String>> mp = new HashMap<>();

        for (String str : A) {
            char[] charArr = str.toCharArray();

            Arrays.sort(charArr);

            String sortedCh = new String(charArr);

            if (mp.containsKey(sortedCh)) {
                mp.get(sortedCh).add(str);

            } else {
                ArrayList<String> grp = new ArrayList<>();
                grp.add(str);
                mp.put(sortedCh, grp);
            }
        }

        ArrayList<ArrayList<String>> groupedAnagrams = new ArrayList<>(mp.values());
        for (List<String> grp : groupedAnagrams) {
            Collections.sort(grp);
        }

        // Sort the 2D list itself based on lexographical order
        groupedAnagrams.sort(Comparator.comparing(list -> list.get(0)));
        // comparing takes a function that extracts a key to compare, hence the above sorting
        // is done based on the first element of the list, as sorting key we provide the
        // function that extracts the first element of the list
        return groupedAnagrams;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ArrayList<String> A = new ArrayList<>();
        A.add("cat");
        A.add("dog");
        A.add("god");
        A.add("tac");
        A.add("act");
        System.out.println(ga.getAnagrams(A));

    }
}