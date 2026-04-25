package solutions.p941;

class Solution {

    public boolean validMountainArray(int[] arr) {

        int n = arr.length;
        int i = 0;

        // must have at least 3 elements
        if (n < 3) return false;

        // climb up (strictly increasing)
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak cannot be first or last
        if (i == 0 || i == n - 1) {
            return false;
        }

        // go down (strictly decreasing)
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
