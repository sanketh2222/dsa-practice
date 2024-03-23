package tries;

import java.util.*;
import java.util.Map;

public class TypeAhead {

    // Pair stores the input string and total frequency
    // search table for queries and their frequencies
    // Note:- This is sorted based on the frequencies and lexographically on the
    // query strings
    class Pair implements Comparable<Pair> {
        long frequency;
        String searchQuery;

        Pair(long frequency, String searchQuery) {
            this.frequency = frequency;
            this.searchQuery = searchQuery;
        }

        // Comparison based on frequency and lexicographically on strings
        @Override
        public int compareTo(Pair pair) {
            if (this.frequency < pair.frequency) {
                return -1;
            } else if (this.frequency > pair.frequency) {
                return 1;
            } else {
                if (this.searchQuery.compareTo(pair.searchQuery) < 0)
                    return -1;
                else if (this.searchQuery.compareTo(pair.searchQuery) > 0)
                    return 1;
                return 0;
            }
        }
    }
    //end of pair class

    // Trie for storing the search
    class TrieNode {
        int isEndOfWord;
        Map<String, Long> map; // Stores the frequency
        LinkedList<Pair> list; // Stores the strings in ascending order of frequency and lexicographical order
        TrieNode[] child;

        TrieNode() {
            isEndOfWord = -1;
            child = new TrieNode[26];
            Arrays.fill(child, null);
            map = new HashMap<>();
            list = new LinkedList<>();
        }
    }
    //end of trie class

    private TrieNode root = new TrieNode(); // Creating a common root node

    private void incrementSearchTermFrequency(String userQuery, int frequency) {
        TrieNode temp = root;
        for (int i = 0; i < userQuery.length(); i++) {
            char ch = userQuery.charAt(i);
            int index = ch - 'a';
            if (temp.child[index] == null) {
                temp.child[index] = new TrieNode();
            }
            temp = temp.child[index];
            int j = 0;

            // If userQuery is present, the increase frequency in map and remove string
            // with older
            // frequency from the list and add string with new frequency in sorted manner in
            // list
            if (temp.map.containsKey(userQuery)) {
                temp.map.put(userQuery, temp.map.get(userQuery) + Long.valueOf(frequency));
                j = 0;
                while (j < temp.list.size() && !temp.list.get(j).searchQuery.equals(userQuery)) {
                    j++;
                }
                temp.list.remove(j);
            } else {
                temp.map.put(userQuery, Long.valueOf(frequency));
            }

            long newFrequency = temp.map.get(userQuery);
            Pair pair = new Pair(newFrequency, userQuery);
            j = 0;
            while ((j < temp.list.size()) && (pair.compareTo(temp.list.get(j)) == 1)) {
                j++;
            }
            temp.list.add(j, pair);
        }

        temp.isEndOfWord = 1;
    }

    // finding strict prefixes else returning blank strings
    private String[] findTopXSuggestion(String queryPrefix, int x) {
        String[] topXsuggestions = new String[x];
        TrieNode temp = root;

        for (int i = 0; i < queryPrefix.length(); i++) {
            char ch = queryPrefix.charAt(i);
            int index = ch - 'a'; // a - a = 0, b - a = 1, c - a = 2
            // if prefix is not present in trie, return list with blank strings
            if (temp.child[index] == null) {
                Arrays.fill(topXsuggestions, "");
                return topXsuggestions;
            } else {
                temp = temp.child[index];
            }
        }

        // If strict prefix is not present in trie, returning list with blank strings
        if (temp == null) {
            Arrays.fill(topXsuggestions, "");
            return topXsuggestions;
        }

        int k = 0;
        int listSize = temp.list.size() - 1;
        while (k < x && listSize >= 0) {
            topXsuggestions[k] = temp.list.get(listSize).searchQuery;
            listSize--;
            k++;
        }

        // Adding blank string if found strings are less than x
        while (k < x) {
            topXsuggestions[k] = "";
            k++;
        }
        Arrays.sort(topXsuggestions); // finally sending the sorted output
        return topXsuggestions;
    }



    public static void main(String[] args) {
        TypeAhead typeAhead = new TypeAhead();
        typeAhead.incrementSearchTermFrequency("michelleobama", 100);
        typeAhead.incrementSearchTermFrequency("michaeljackson", 90);
        typeAhead.incrementSearchTermFrequency("michaeljordan", 120);
        String[] suggestions = typeAhead.findTopXSuggestion("mic", 2);
        System.out.println(Arrays.toString(suggestions));

        typeAhead.incrementSearchTermFrequency("bat", 10);
        typeAhead.incrementSearchTermFrequency("cricket", 20);
        typeAhead.incrementSearchTermFrequency("ball", 15);
        suggestions = typeAhead.findTopXSuggestion("b", 2);
        System.out.println(Arrays.toString(suggestions));

    }
}