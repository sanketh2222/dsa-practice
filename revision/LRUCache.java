package revision;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

/**
 * Most recenlty used will be left side
 * Least recently used will be right side
 * Hence additions are made from right to left
 */
public class LRUCache {

    private Map<Integer, Node> hashMap;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        initializeLRU();
    }

    private void initializeLRU() {
        this.hashMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // check if the key exists
        // if exits then make it MRU and return the value
        // Making MRU
        // delete/remove
        // detete the node from the existig location (Disconnect the connections)
        // remove from hashmap
        // create a new node with same data

        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            remove(node);
            insert(node);
            hashMap.put(key, node);
            return node.value;
        }

        return -1;
        // insert
        // add it next to head
        // update the hashmp with new address/object/location

    }

    public void set(int key, int value) {
        // check if capacity is reached
        Node newNode = new Node(key, value);

        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            remove(node);

        }
        // if capacity is reached
        else if (hashMap.size() == capacity) {
            // if capacity is reached then remove/delete the LRU
            Node lruNode = tail.prev;
            remove(lruNode);

        }
        insert(newNode);
        hashMap.put(key, newNode);

        // else create a new node
        // add it next to head
        // update the hashmap
    }

    private void insert(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        hashMap.remove(node.key);
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        // LRUCache cache = new LRUCache(2);
        // cache.set(1, 10);
        // cache.set(5, 12);
        // System.out.println(cache.get(5));
        // System.out.println(cache.get(1));
        // System.out.println(cache.get(10));
        // cache.set(6, 14);
        // System.out.println(cache.get(5));

        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2, 6);
        System.out.println(cache.get(1));
        cache.set(1, 5);
        cache.set(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
