package solutions.p705;

import java.util.ArrayList;
import  java.util.List;

class MyHashSet {

    private static final int BUCKETS = 769;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void add(int key) {
        int hashed_key = hash(key);
        List<Integer> bucket = buckets[hashed_key];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hashed_key = hash(key);
        List<Integer> bucket = buckets[hashed_key];
        bucket.remove((Integer) key);  // cast needed to remove the object, not by index
    }

    public boolean contains(int key) {
        int hashed_key = hash(key);
        List<Integer> bucket = buckets[hashed_key];
        return bucket.contains(key);
    }
}
