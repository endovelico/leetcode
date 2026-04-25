package solutions.p961;

class Solution {
    public int repeatedNTimes(int[] nums) {

        int number_count = nums.length;

        for (int first_index = 0; first_index < number_count; first_index++) {

            for (int second_index = 1; second_index <= 3; second_index++) {

                if (first_index + second_index < number_count && nums[first_index] == nums[first_index + second_index]) {
                    return nums[first_index];
                }
            }
        }

        return -1;
    }
}