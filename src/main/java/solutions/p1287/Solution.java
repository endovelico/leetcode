package solutions.p1287;

class Solution {
    public int findSpecialInteger(int[] arr) {

        int threshold = arr.length / 4;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i == 0 || arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > threshold) {
                return arr[i];
            }
        }

        return -1;
    }
}