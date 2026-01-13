package solutions.p295;


import java.util.PriorityQueue;

import java.util.PriorityQueue;

public class MedianFinder {

    // Max heap for lower half
    private PriorityQueue<Integer> left;

    // Min heap for upper half
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a); // max heap
        right = new PriorityQueue<>();               // min heap
    }

    public void addNum(int num) {

        // Step 1: Add to correct heap
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Step 2: Rebalance heaps
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        // Even number of elements
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        // Odd number of elements
        return left.peek();
    }
}

