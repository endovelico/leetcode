package solutions.p3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0; // store the max length found
        int left = 0;   // left pointer of sliding window
        Map<Character, Integer> map = new HashMap<>(); // stores last index of each char

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // if the character is already in the map, move left pointer
            if (map.containsKey(c)) {
                // move left to the next of previous occurrence of c
                left = Math.max(map.get(c) + 1, left);
            }

            // update the last seen index of c
            map.put(c, right);

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
