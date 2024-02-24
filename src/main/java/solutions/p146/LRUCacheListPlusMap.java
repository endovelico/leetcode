package solutions.p146;

import common.CacheNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheListPlusMap {
    private CacheNode head = new CacheNode(0, 0);
    private CacheNode tail = new CacheNode(0, 0);
    private Map<Integer, CacheNode> cache = new HashMap<>();
    int capacity = 0;

    public LRUCacheListPlusMap(int capacity) {
        this.capacity = capacity;
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.getPrevious());
        }
        insert(new CacheNode(key, value));
    }

    public void insert(CacheNode node) {
        cache.put(node.getKey(), node);
        node.setNext(head.getNext());
        node.getNext().setPrevious(node);
        head.setNext(node);
        node.setPrevious(head);
    }

    public void remove(CacheNode node) {
        cache.remove(node.getKey());
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }
}
