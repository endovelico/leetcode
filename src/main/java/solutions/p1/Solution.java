package solutions.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> wantedNumbers = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int currentNumber = nums[index];
            int numberINeed = target - currentNumber;

            if (wantedNumbers.containsKey(numberINeed)) {
                return new int[]{ wantedNumbers.get(numberINeed), index };
            } else {
                wantedNumbers.put(currentNumber, index);
            }
        }

        return new int[]{};
    }
}
