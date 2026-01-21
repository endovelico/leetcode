package solutions.p291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        return backtracking_pattern_matching(pattern, 0, str, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean backtracking_pattern_matching(String pattern, int pIndex, String str, int sIndex,
                              Map<Character, String> map, Set<String> used) {

        // Base case: both pattern and string fully matched
        if (pIndex == pattern.length() && sIndex == str.length()) {
            return true;
        }
        // Fail case: one finished but not the other
        if (pIndex == pattern.length() || sIndex == str.length()) {
            return false;
        }

        char ch = pattern.charAt(pIndex);

        // If character already mapped, check consistency
        if (map.containsKey(ch)) {
            String mapped = map.get(ch);
            if (str.startsWith(mapped, sIndex)) {
                // Recurse for next part
                return backtracking_pattern_matching(pattern, pIndex + 1, str, sIndex + mapped.length(), map, used);
            } else {
                return false; // mapping conflict
            }
        }

        // Try all possible substrings for current pattern character
        for (int len = 1; sIndex + len <= str.length(); len++) {
            String candidate = str.substring(sIndex, sIndex + len);

            // Skip if this substring is already used
            if (used.contains(candidate)) continue;

            // Assign mapping
            map.put(ch, candidate);
            used.add(candidate);

            // Recurse
            if (backtracking_pattern_matching(pattern, pIndex + 1, str, sIndex + len, map, used)) {
                return true;
            }

            // Backtrack
            map.remove(ch);
            used.remove(candidate);
        }

        // No valid mapping found
        return false;
    }


}