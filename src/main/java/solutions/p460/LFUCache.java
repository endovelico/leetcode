package solutions.p460;

import common.FrequencyCacheNode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private final int capacity;
    private int minFreq;
    private Map<Integer, FrequencyCacheNode> keyNodeMap;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }

        FrequencyCacheNode node = keyNodeMap.get(key);
        updateFrequency(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            FrequencyCacheNode node = keyNodeMap.get(key);
            node.setValue(value);
            updateFrequency(node);
        } else {
            if (keyNodeMap.size() == capacity) {
                // Evict least frequently used key
                LinkedHashSet<Integer> keys = freqMap.get(minFreq);
                int evictKey = keys.iterator().next();
                keys.remove(evictKey);
                if (keys.isEmpty()) {
                    freqMap.remove(minFreq);
                }
                keyNodeMap.remove(evictKey);
            }

            FrequencyCacheNode newNode = new FrequencyCacheNode(key, value);
            keyNodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFrequency(FrequencyCacheNode node) {
        int oldFreq = node.getFrequency();
        freqMap.get(oldFreq).remove(node.getKey());
        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        int node_freq = node.getFrequency();
        node.setFrequency(node_freq++);

        freqMap.computeIfAbsent(node.getFrequency(), k -> new LinkedHashSet<>()).add(node.getKey());
    }
}
