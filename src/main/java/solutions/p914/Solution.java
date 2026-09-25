package solutions.p914;

import java.util.Arrays;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);

        int gcd = 0;
        int count = 1;

        for (int i = 1; i <= deck.length; i++) {
            if (i == deck.length || deck[i] != deck[i - 1]) {
                gcd = findGCD(gcd, count);
                count = 1;
            } else {
                count++;
            }
        }

        return gcd >= 2;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}