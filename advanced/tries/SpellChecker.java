package tries;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SpellChecker {

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
}
