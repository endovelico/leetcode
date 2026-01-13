package solutions.p1636;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> {
                    if (!freq.get(a).equals(freq.get(b))) {
                        return freq.get(a) - freq.get(b);
                    }
                    return b - a;
                }
        );

        heap.addAll(freq.keySet());

        int[] result = new int[nums.length];
        int index = 0;

        while (!heap.isEmpty()) {
            int val = heap.poll();
            int count = freq.get(val);
            for (int i = 0; i < count; i++) {
                result[index++] = val;
            }
        }

        return result;
    }
}
