package solutions.p1013;

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {

        int total = 0;
        for(int x : arr) total += x;

        if (total % 3 != 0) return false;

        int target = total / 3;
        int runningSum = 0;
        int parts = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];

            if (runningSum == target) {
                parts++;
                runningSum = 0;
            }
        }

        return parts >= 3;
    }
}