package solutions.p896;

class Solution {
    public boolean isMonotonic(int[] arr) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                decreasing = false; // violated non-increasing
            }
            if (arr[i] < arr[i - 1]) {
                increasing = false; // violated non-decreasing
            }
        }

        return increasing || decreasing;
    }
}