package solutions.p703;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer>  minHeap;
    private Integer k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
