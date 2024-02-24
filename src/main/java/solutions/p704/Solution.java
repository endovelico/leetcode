package solutions.p704;

public class Solution {
    public int search(int[] nums, int target) {

        int dictionary_bookmark = nums.length / 2;
        int min_searched_index = 0;
        int max_searched_index = nums.length;
        final int NOT_FOUND_FLAG = -1;

        while(true) {

            if (nums[dictionary_bookmark] == target) return dictionary_bookmark;
            if(max_searched_index - min_searched_index == 1) return NOT_FOUND_FLAG;

            if (nums[dictionary_bookmark] > target) {
                max_searched_index = dictionary_bookmark;
            }

            if (nums[dictionary_bookmark] < target ) {
                min_searched_index = dictionary_bookmark;
            }
            dictionary_bookmark = ((max_searched_index - min_searched_index) / 2) + min_searched_index;
        }
    }
}
