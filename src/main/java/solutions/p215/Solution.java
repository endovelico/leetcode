package solutions.p215;

import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        
        for (int number: nums) { 
            
           addToHeap(number, min_heap, k);
        }

        return min_heap.poll();
    }

    private void addToHeap(int number, PriorityQueue<Integer> minHeap, int k) {

        if( minHeap.size() >= k){

            if( number > minHeap.peek()) {

                minHeap.poll();
                minHeap.offer(number);
            }

        } else {

            minHeap.offer(number);
        }
    }
}
