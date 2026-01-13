package solutions.p746;

public class SolutionTabulation {

    public int rob(int[] nums) {
        int number_of_houses = nums.length;

        if (number_of_houses == 0) return 0;
        if (number_of_houses == 1) return nums[0];

        int[] dp = new int[number_of_houses];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < number_of_houses; i++) {
            dp[i] = Math.max(
                    dp[i - 1],          // skip current house
                    dp[i - 2] + nums[i] // rob current house
            );
        }

        return dp[number_of_houses - 1];
    }
}
