package solutions.p1365;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        // count frequency of each number
        for (int n : nums) {
            freq[n]++;
        }

        // prefix sums: how many numbers are smaller
        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }

        return result;
    }
}

