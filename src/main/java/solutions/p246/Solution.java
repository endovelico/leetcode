package solutions.p246;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    private static final Map<Character, Character> STROBO_MAP = Map.of(
            '0', '0',
            '1', '1',
            '8', '8',
            '6', '9',
            '9', '6'
    );

    public boolean isStrobogrammatic(String num) {
        if (num == null) return false;

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);

            if (!STROBO_MAP.containsKey(l)) return false;
            if (STROBO_MAP.get(l) != r) return false;

            left++;
            right--;
        }

        return true;
    }
}
