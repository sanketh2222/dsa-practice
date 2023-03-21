package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpellChecker  {

    public class Node {
        boolean isEnd;
        Map<Character, Node> mp;

        Node() {
            this.mp = new HashMap<>();
        }
    }

    private void insert(String str, Node root) {
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (!root.mp.containsKey(str.charAt(i))) {
                Node r = new Node();
                root.mp.put(str.charAt(i), r);
                root = r;

            } else {
                root = root.mp.get(str.charAt(i));
            }
        }

        root.isEnd = true;

    }

    private int find(String str, Node root) {
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (!root.mp.containsKey(str.charAt(i))) {
                return 0;

            } else {
                root = root.mp.get(str.charAt(i));
            }
        }
        return root.isEnd ? 1 : 0;
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        Node root = new Node();
        ArrayList<Integer> result = new ArrayList<Integer>();
        A.forEach(x -> insert(x, root));
        B.forEach(x -> result.add(find(x, root)));
        return result;
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("hat", "cat", "rat"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("cat", "ball"));
        ArrayList<Integer> result = spellChecker.solve(A, B);
        result.forEach(System.out::println);
        // ArrayList<String> A = (ArrayList<String>) Arrays.asList("hat", "cat", "rat");
        // ArrayList<String> B = (ArrayList<String>) Arrays.asList("cat", "ball");

    }
}
