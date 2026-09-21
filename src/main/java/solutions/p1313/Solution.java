package solutions.p1313;

import java.util.ArrayList;

class Solution {
    public int[] decompressRLElist(int[] nums) {

        // First, calculate how many elements the result will have
        int size = 0;

        for (int i = 0; i < nums.length; i += 2) {
            int frequency = nums[i];
            size += frequency;
        }

        int[] array = new int[size];

        // Position where we insert the next number
        int index = 0;

        // Iterate two by two
        for (int i = 0; i < nums.length; i += 2) {

            // Break up the pair
            int frequency = nums[i];
            int number = nums[i + 1];

            // Decompress the pair
            for (int j = frequency; j > 0; j--) {
                array[index] = number;
                index++;
            }
        }

        return array;
    }
}