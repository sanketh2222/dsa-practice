package interemediate;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LRUCache {
    class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        updateToMostRecentlyUsed(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addToMostRecentlyUsed(node);

            if (cache.size() > capacity) {
                removeLeastRecentlyUsed();
            }
        } else {
            node.value = value;
            updateToMostRecentlyUsed(node);
        }
    }

    private void addToMostRecentlyUsed(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void updateToMostRecentlyUsed(Node node) {
        if (node == head) {
            return;
        }

        if (node == tail) {
            tail = tail.prev;
        }

        node.prev.next = node.next;

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    private void removeLeastRecentlyUsed() {
        cache.remove(tail.key);
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(5, 12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.set(6, 14);
        System.out.println(cache.get(5));

        // test case 2
        cache = new LRUCache(1);
        cache.set(2, 1);
        cache.set(2, 2);
        System.out.println(cache.get(2));
        cache.set(1, 1);
        cache.set(4, 1);
        System.out.println(cache.get(2));

        cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2, 6);
        System.out.println(cache.get(1));
        cache.set(1, 5);
        cache.set(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

}
