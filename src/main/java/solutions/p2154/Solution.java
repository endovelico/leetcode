package solutions.p2154;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findFinalValue(int[] nums, int original) {

        if ( original == 0) return 0;
        Set<Integer> occurrences = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            occurrences.add(nums[i]);
        }

        int original_sum = original;
        while (true){

            if( occurrences.contains(original_sum)) { original_sum = original_sum * 2; }
            else break;

        }

        return original_sum;
    }
}
