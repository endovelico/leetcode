package solutions.p973;

import java.util.PriorityQueue;

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max-heap by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}

