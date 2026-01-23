package solutions.p1708;

class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int totalLength = nums.length;
        int maxStartIndex = 0; // index where the largest subarray starts

        // The number of possible starting indices for a subarray of length k
        int numCandidates = totalLength - k + 1;

        // Iterate over all candidate starting indices
        for (int candidateStart = 1; candidateStart < numCandidates; candidateStart++) {
            int offset = 0;

            // Compare subarray starting at candidateStart with the current best
            while (offset < k && nums[candidateStart + offset] == nums[maxStartIndex + offset]) {
                offset++;
            }

            // If candidate subarray is lexicographically larger, update maxStartIndex
            if (offset < k && nums[candidateStart + offset] > nums[maxStartIndex + offset]) {
                maxStartIndex = candidateStart;
            }
        }

        // Build the result subarray
        int[] largestSubarray = new int[k];
        for (int i = 0; i < k; i++) {
            largestSubarray[i] = nums[maxStartIndex + i];
        }

        return largestSubarray;
    }
}
