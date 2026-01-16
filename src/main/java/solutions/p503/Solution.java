package solutions.p503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int number_of_elements = nums.length;
        int[] result = new int[number_of_elements];
        Arrays.fill(result, -1); //default if no greater element;
        Deque<Integer> monotonic_stack = new ArrayDeque<>(); //Store indexes

        // Transverse twice for circular array
        for (int cursor = 0; cursor < 2 * number_of_elements; cursor++) {

            int current_index = cursor % number_of_elements;

            // Pop smaller element and assign their next greater
            while( !monotonic_stack.isEmpty() && nums[current_index] > nums[monotonic_stack.peek()]) {

                int result_index = monotonic_stack.pop();
                result[result_index] = nums[current_index];

            }

            // Only push first pass indexes
            if( cursor < number_of_elements) {monotonic_stack.push(current_index);}

        }

        return result;
    }

}