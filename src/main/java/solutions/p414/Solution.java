package solutions.p414;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.add(num)) {
                heap.offer(num);
                if (heap.size() > 3) {
                    heap.poll(); // remove smallest
                }
            }
        }

        // If fewer than 3 distinct values, return the max
        if (heap.size() < 3) {
            int max = Integer.MIN_VALUE;
            for (int n : heap) {
                max = Math.max(max, n);
            }
            return max;
        }

        // Otherwise, the root is the 3rd maximum
        return heap.peek();
    }
}
