package solutions.p373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static class Node {
        int i, j, sum;
        Node(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        // Seed the frontier
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new Node(i, 0, nums1[i] + nums2[0]));
        }

        // Expand the frontier
        while (k-- > 0 && !minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            result.add(List.of(
                    nums1[curr.i],
                    nums2[curr.j]
            ));

            // Push the next pair from the same row
            if (curr.j + 1 < nums2.length) {
                minHeap.offer(
                        new Node(
                                curr.i,
                                curr.j + 1,
                                nums1[curr.i] + nums2[curr.j + 1]
                        )
                );
            }
        }

        return result;
    }
}
