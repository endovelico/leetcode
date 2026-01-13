package solutions.p1089;

class Solution {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int zerosToDuplicate = 0;

        // Step 1: Count how many zeros we need to duplicate
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                zerosToDuplicate++;
            }
        }

        // Step 2: Start from the end
        int originalIndex = length - 1;
        int newIndex = length + zerosToDuplicate - 1; // virtual end including duplicates

        // Step 3: Move elements backward
        while (originalIndex >= 0) {
            if (newIndex < length) {
                arr[newIndex] = arr[originalIndex]; // copy element to new position
            }

            // If it's zero, duplicate it
            if (arr[originalIndex] == 0) {
                newIndex--;
                if (newIndex < length) {
                    arr[newIndex] = 0;
                }
            }

            originalIndex--;
            newIndex--;
        }
    }
}
