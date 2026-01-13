package solutions.p27;

class Solution {
    public int removeElement(int[] nums, int val) {

        int insertable_position = 0;

        for(int main_cursor = 0;  main_cursor < nums.length; main_cursor++) {

            if( nums[main_cursor] != val) {

                if(insertable_position != main_cursor) { nums[insertable_position] = nums[main_cursor];}
                insertable_position++;
            }


        }


        return insertable_position;
    }
}