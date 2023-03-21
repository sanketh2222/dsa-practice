package advanced;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoublyLinkedList {
        private DoublyLinkedList prev;
        private DoublyLinkedList next;
        private int value;

        public DoublyLinkedList(int value) {
            this.prev = null;
            this.next = null;
            this.value = value;
        }
    }

    private Map<Integer, DoublyLinkedList> lruCache;
    private int capacity;
    private DoublyLinkedList mru;
    private DoublyLinkedList lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruCache = new HashMap<Integer, DoublyLinkedList>();// value , LLs
        this.mru = null;
        this.lru = null;
    }

    public int get(int key) {
        DoublyLinkedList existingNode = lruCache.getOrDefault(key, null);
        // If found Update key to MRU

        if (existingNode == null) {
            return -1;

        } else if (existingNode.prev != null && existingNode.next != null && lruCache.size() > 1) { // node is present
                                                                                                    // in between

            // Delete this node from between
            DoublyLinkedList prevNode = existingNode.prev;
            DoublyLinkedList nextNode = existingNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

        } else if (existingNode.prev == null && lruCache.size() > 1) {
            lru = lru.next;

        }

        if (lruCache.size() > 1) {
            // Make this as a MRU
            DoublyLinkedList currNode = existingNode;
            mru.next = currNode;
            currNode.prev = mru;
            mru = currNode;
            return existingNode.value;
        }

        return existingNode.value;

    }

    public void set(int key, int value) {

        if (lruCache.size() == 0) {
            insertHead(key, value);// mru

        } else if (lruCache.size() == capacity) { // Check if LRU Cache is full
            evictAndInsert(key, value);

        } else {
            insertTail(key, value);// lru
        }

    }

    //insert in between
    private void evictAndInsert(int key, int value) {
        DoublyLinkedList currNode = new DoublyLinkedList(value);

        if (!lruCache.containsKey(key))
            lruCache.values().remove(lru);

        if (lru == mru) {
            insertHead(key, value);
        } else {
            lru = lru.next;
            mru.next = currNode;
            currNode.prev = mru;
            mru = currNode;
            lruCache.put(key, currNode);
        }

    }

    private void insertTail(int key, int value) {
        // Set the incomming node as MRU
        DoublyLinkedList currNode = new DoublyLinkedList(value);
        mru.next = currNode;
        currNode.prev = mru;
        mru = currNode;
        lruCache.put(key, currNode);
    }

    private void insertHead(int key, int value) {
        // mru and lru will be same, during first insert
        DoublyLinkedList currNode = new DoublyLinkedList(value);
        mru = currNode;
        lru = currNode;
        lruCache.put(key, currNode);

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
