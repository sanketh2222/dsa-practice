package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AutoComplete {
    static final int NUM_OF_CHARS = 128;

    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[NUM_OF_CHARS];
        boolean isEnd = false;
        int frequency; // Added frequency field

        TrieNode(char c) {
            data = c;
        }
    }

    TrieNode root = new TrieNode(' ');

    public void incrementSearchTermFrequency(String word, int frequency) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch] == null)
                node.children[ch] = new TrieNode(ch);
            node = node.children[ch];
        }
        node.isEnd = true;
        node.frequency = frequency;
    }

    public String[] findTopXSuggestion(String prefix, int x) {
        TrieNode node = root;
        List<String> res = new ArrayList<>();
        for (char ch : prefix.toCharArray()) {
            node = node.children[ch];
            if (node == null)
                return new String[x];
        }
        collectSuggestions(node, res, prefix.substring(0, prefix.length() - 1));
        Collections.sort(res, (a, b) -> {
            TrieNode nodeA = getNodeByWord(root, a);
            TrieNode nodeB = getNodeByWord(root, b);
            if (nodeA.frequency != nodeB.frequency) {
                return Integer.compare(nodeB.frequency, nodeA.frequency);
            }
            return a.compareTo(b);
        });
        return res.subList(0, Math.min(x, res.size())).stream().toArray(String[]::new);
    }

    private void collectSuggestions(TrieNode node, List<String> res, String prefix) {
        if (node == null)
            return;
        if (node.isEnd)
            res.add(prefix + node.data);
        for (TrieNode child : node.children)
            collectSuggestions(child, res, prefix + node.data);
    }

    private TrieNode getNodeByWord(TrieNode node, String word) {
        for (char ch : word.toCharArray()) {
            node = node.children[ch];
        }
        return node;
    }

    public static void main(String[] args) {
        AutoComplete t = new AutoComplete();
        // Trie t = autoComplete.new Trie();
        t.incrementSearchTermFrequency("amazon", 10);
        t.incrementSearchTermFrequency("amazon prime", 6);
        t.incrementSearchTermFrequency("amazing", 7);
        t.incrementSearchTermFrequency("amazing spider man", 3);
        t.incrementSearchTermFrequency("amazed", 1);
        t.incrementSearchTermFrequency("apple", 5);
        System.out.println(Arrays.toString(t.findTopXSuggestion("amaz", 3)));
    }
}
