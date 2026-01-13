package solutions.p1046;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {

            int x = maxHeap.poll(); // heaviest
            int y = maxHeap.poll(); // second heaviest

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }



}
