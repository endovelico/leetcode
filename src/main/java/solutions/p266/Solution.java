package solutions.p266;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c); // even count → remove
            } else {
                set.add(c); // odd count → add
            }
        }

        return set.size() <= 1;
    }
}