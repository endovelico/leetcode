package solutions.p1394;

import java.util.Arrays;

class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);

        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            count++;

            // End of this group, or we've reached the beginning
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (count == arr[i]) {
                    return arr[i];
                }
                count = 0;
            }
        }

        return -1;
    }
}