package solutions.p1710;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort boxTypes in descending order of units per box
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;       // total units loaded onto the truck
        int remainingTruckSpace = truckSize;

        // Iterate over each box type
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int unitsPerBox = boxType[1];

            // Take as many boxes as possible, up to remaining truck capacity
            int boxesToTake = Math.min(numberOfBoxes, remainingTruckSpace);

            totalUnits += boxesToTake * unitsPerBox;
            remainingTruckSpace -= boxesToTake;

            // Truck is full, stop
            if (remainingTruckSpace == 0) {
                break;
            }
        }

        return totalUnits;
    }
}
