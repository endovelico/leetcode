package solutions.p93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int start, int dotsPlaced, StringBuilder path, List<String> res) {
        int lengthBefore = path.length();

        // Base case: 3 dots placed
        if (dotsPlaced == 3) {
            String remaining = s.substring(start);
            if (isValid(remaining)) {
                path.append(remaining);
                res.add(path.toString());
                path.setLength(lengthBefore); // backtrack
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (!isValid(segment)) continue;

            path.append(segment).append('.');
            backtrack(s, start + len, dotsPlaced + 1, path, res);
            path.setLength(lengthBefore); // remove segment + dot
        }
    }

    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        if (s.startsWith("0") && s.length() > 1) return false; // no leading zeros
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
