package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;

public class Test {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);

            if (mp.containsKey(sortedStr)) {
                mp.get(sortedStr).add(str);

            } else {
                mp.put(sortedStr, new ArrayList<>(Arrays.asList(str))); // Use ArrayList instead of Arrays.asList
            }
        }

        List<List<String>> groupedAnagrams = new ArrayList<>(mp.values());

        for (List<String> grp : groupedAnagrams) {
            Collections.sort(grp);
        }

        return groupedAnagrams;

    }

    public static void main(String[] args) {
        String s = "bac";
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        System.out.println(new String(ch));
        List<String> A = Arrays.asList("cat", "dog", "god", "tac", "act");
        A.add("cat");// This will throw UnsupportedOperationException because Arrays.asList returns a
                     // fixed-size list

        List<String> B = List.of("cat", "dog", "god", "tac", "act");
        // B.add("cat"); // This will throw UnsupportedOperationException because
        // List.of returns an immutable list
    }
}
