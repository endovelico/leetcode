package solutions.p169;

import java.util.HashMap;

public class Solution {

    public int majorityElement(int[] nums) {

        if(nums.length == 1) return nums[0];

        HashMap<Integer, Integer> count_map = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++) {
            Integer count = count_map.get(nums[index]);
            count = (count == null) ? 1 : count + 1;

            if(count > nums.length / 2) return nums[index];
            count_map.put(nums[index], count);
        }
        return 0;
    }

    public static void main(String []args) {
        Solution solution = new Solution();
        int result = solution.majorityElement(new int[]{3, 2, 3});
        System.out.println(result);
    }
}