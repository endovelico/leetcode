package solutions.p378;


import java.util.PriorityQueue;

class Solution {

    static class Node {
        int val, r, c;
        Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // push first element of each row
        for (int r = 0; r < matrix.length; r++) {
            minHeap.offer(new Node(matrix[r][0], r, 0));
        }

        Node curr = null;

        for (int i = 0; i < k; i++) {
            curr = minHeap.poll();

            if (curr.c + 1 < matrix[0].length) {
                minHeap.offer(
                        new Node(matrix[curr.r][curr.c + 1],
                                curr.r,
                                curr.c + 1)
                );
            }
        }

        return curr.val;
    }
}
