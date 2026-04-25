package solutions.p374;

import solutions.p374.common.GuessGame;

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoid overflow
            int res = guess(mid);

            if (res == 0) {
                return mid; // found the number
            } else if (res < 0) {
                high = mid - 1; // number is lower
            } else {
                low = mid + 1; // number is higher
            }
        }

        // Should never reach here if the number is guaranteed
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
