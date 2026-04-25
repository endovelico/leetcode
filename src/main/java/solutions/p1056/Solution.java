package solutions.p1056;

import java.util.Map;
import java.util.Set;

class Solution {

    private final Map<Integer, Integer> map = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6
    );

    public boolean confusingNumber(int n) {
        int original = n;
        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;

            if (!map.containsKey(digit)) return false;

            reversed = reversed * 10 + map.get(digit);
            n /= 10;
        }

        return reversed != original;
    }
}