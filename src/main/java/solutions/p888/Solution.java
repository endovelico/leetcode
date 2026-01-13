package solutions.p888;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int x : A) sumA += x;
        for (int y : B) sumB += y;

        int delta = (sumA - sumB) / 2; // x - y = delta
        Set<Integer> setB = new HashSet<>();
        for (int y : B) setB.add(y);

        for (int x : A) {
            int y = x - delta;
            if (setB.contains(y)) return new int[]{x, y};
        }

        return new int[0]; // technically won't happen
    }
}