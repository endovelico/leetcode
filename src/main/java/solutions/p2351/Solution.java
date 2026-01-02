package solutions.p2351;

public class Solution {

    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx]) {
                return c;
            }
            seen[idx] = true;
        }

        // Problem guarantees an answer exists
        return ' ';
    }
}
