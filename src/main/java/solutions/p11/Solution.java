package solutions.p11;

public class Solution {

    public int maxArea(int[] height) {

        int max_area = 0;
        int lower_bound = 0;
        int upper_bound = height.length - 1;

        while (lower_bound < upper_bound) {
            max_area = Math.max(max_area, Math.min(height[lower_bound], height[upper_bound]) * (upper_bound - lower_bound));
            if (height[lower_bound] < height[upper_bound])
                lower_bound++;
            else
                upper_bound--;
        }
        return max_area;
    }
}