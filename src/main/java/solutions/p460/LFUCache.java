package solutions.p460;

import common.FrequencyCacheNode;

import java.util.*;

public class LFUCache {

    private final int capacity;
    private final Map<Integer, FrequencyCacheNode> keyNodeMap = new HashMap<>();
    private final Map<Integer, Integer> keyFreqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        keyFreqMap.put(key, keyFreqMap.get(key) + 1);
        int current_node_frequency = keyNodeMap.get(key).getFrequency();
        keyNodeMap.get(key).setFrequency(current_node_frequency++);

        return keyNodeMap.get(key).getValue();
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            FrequencyCacheNode node = keyNodeMap.get(key);
            node.setValue(value);
            node.getFrequency();
            keyFreqMap.put(key, node.getFrequency());
            return;
        }

        if (keyNodeMap.size() >= capacity) {
            // Find LFU key (no recency tie-breaking)
            int lfuKey = Collections.min(keyFreqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
            keyNodeMap.remove(lfuKey);
            keyFreqMap.remove(lfuKey);
        }

        FrequencyCacheNode newNode = new FrequencyCacheNode(key, value);
        keyNodeMap.put(key, newNode);
        keyFreqMap.put(key, 1);
    }
}
