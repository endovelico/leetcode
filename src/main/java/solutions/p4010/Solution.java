package solutions.p4010;

class Solution {

    public long maxStrength(int[] nums) {

        long maxStrength = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                long a = nums[i];
                long b = nums[j];

                long gcd = gcd(a, b);

                long strength = (a * b) / (gcd * gcd);

                maxStrength = Math.max(maxStrength, strength);
            }
        }

        return maxStrength;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}