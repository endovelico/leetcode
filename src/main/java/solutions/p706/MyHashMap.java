package solutions.p706;

import common.KeyValuePairNode;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private static final int BUCKETS = 769; // prime number for better distribution
    private List<KeyValuePairNode>[] buckets;

    public MyHashMap() {
        buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        List<KeyValuePairNode> bucket = buckets[idx];

        for (KeyValuePairNode p : bucket) {
            if (p.getKey() == key) {    // key exists → update
                p.value = value;
                return;
            }
        }

        bucket.add(new KeyValuePairNode(key, value)); // key not found → add new pair
    }

    public int get(int key) {
        int idx = hash(key);
        List<KeyValuePairNode> bucket = buckets[idx];

        for (KeyValuePairNode p : bucket) {
            if (p.getKey() == key) return p.value;
        }

        return -1; // key not found
    }

    public void remove(int key) {
        int idx = hash(key);
        List<KeyValuePairNode> bucket = buckets[idx];

        // remove pair with the key
        bucket.removeIf(p -> p.getKey() == key);
    }
}


