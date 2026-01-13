package solutions.p976;

import java.util.Arrays;

public class Solution {

        public int largestPerimeter(int[] nums) {

            Arrays.sort(nums);

            // a + b > c
            for(int cursor = nums.length - 1; cursor >= 2; cursor--) {

                int side_a = nums[cursor - 2];
                int side_b = nums[cursor - 1];
                int side_c = nums[cursor];

                if( side_a + side_b > side_c) return side_a + side_b + side_c;
            }


            return 0;
        }
}
