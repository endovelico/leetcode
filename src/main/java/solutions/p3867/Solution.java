package solutions.p3867;

import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {

        int n = nums.length;

        // Step 1: Build prefixGcd
        int[] prefixGcd = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        // Step 2: Sort
        Arrays.sort(prefixGcd);

        // Step 3: Pair smallest with largest
        long sum = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {

            sum += gcd(prefixGcd[left], prefixGcd[right]);

            left++;
            right--;
        }

        return sum;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
