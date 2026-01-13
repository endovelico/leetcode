package solutions.p347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : nums) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (!occurrenceMap.get(a).equals(occurrenceMap.get(b))) {
                        return occurrenceMap.get(a) - occurrenceMap.get(b);
                    }
                    return b - a;
                }
        );

        for (int num : occurrenceMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }
}
