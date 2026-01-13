package solutions.p26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int index_i = 0; // last unique element index

        for (int index_j = 1; index_j < nums.length; index_j++) {
            if (nums[index_j] != nums[index_i]) {
                index_i++;
                nums[index_i] = nums[index_j]; // overwrite next position with new unique
            }
        }

        return index_i + 1; // new length
    }
}
// nums = [0,0,1,1,1,2,2,3,3,4]
