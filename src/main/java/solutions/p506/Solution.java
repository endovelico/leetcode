package solutions.p506;

import java.util.PriorityQueue;

public class Solution {

    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];

        // Max-heap: higher score first
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Push (score, index)
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{score[i], i});
        }

        int rank = 1;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int idx = curr[1];

            if (rank == 1) result[idx] = "Gold Medal";
            else if (rank == 2) result[idx] = "Silver Medal";
            else if (rank == 3) result[idx] = "Bronze Medal";
            else result[idx] = String.valueOf(rank);

            rank++;
        }

        return result;
    }


    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
    }
}
