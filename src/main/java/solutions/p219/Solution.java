package solutions.p219;

public class Solution {

    public boolean containsNearbyDuplicate(int[] numbers_array, int offset) {

        for (int i = 0; i < numbers_array.length; i++)
            for (int j = i + 1; j < numbers_array.length; j++) {

                if(numbers_array[i] != numbers_array[j]) continue;
                if( Math.abs(i - j) <= offset || Math.abs(j - i) <= offset) return true;
            }

        return false;
    }
}
