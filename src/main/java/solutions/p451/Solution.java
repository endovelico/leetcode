package solutions.p451;

import java.util.*;

public class Solution {

    public String frequencySort(String s) {

        // 1. Count frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 2. Bucket sort by frequency
        // index = frequency, value = list of chars with that frequency
        List<Character>[] buckets = new List[s.length() + 1];

        for (char c : freq.keySet()) {
            int count = freq.get(c);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(c);
        }

        // 3. Build result from highest freq to lowest
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    sb.append(String.valueOf(c).repeat(i));
                }
            }
        }

        return sb.toString();
    }

    public String frequencySortPriorityQueue(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        pq.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(freq.get(c)));
        }

        return sb.toString();
    }
}
