package solutions.p804;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // Morse code for letters 'a' to 'z'
        String[] morse = new String[] {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };

        // Use a HashSet to count unique transformations
        Set<String> transformations = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            transformations.add(sb.toString());
        }

        return transformations.size();
    }
}