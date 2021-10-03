package solutions.p290;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String []args) {
        Solution sol = new Solution();
        boolean b = sol.wordPattern("abba", "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) return false;

        String[] filtered_string = s.split(" ");
        if (filtered_string.length != pattern.length()) return false;

        Map<Character, String> character_map = new HashMap<Character, String>();

        for (int index = 0; index < pattern.length(); index++) {

            Character current_character = pattern.charAt(index);
            String current_word = filtered_string[index];

            // IF THE CURRENT CHARACTER IS ALREADY MAPPED TO A WORD, AND THAT WORD IS NOT THE CURRENT ONE
            if (character_map.get(current_character) != null &&
                    !character_map.get(current_character).equals(current_word)) return false;

            // IF CHARACTER ISN'T IN THE MAP, BUT THE WORD IS ON THE MAP = FALSE
            if(!character_map.containsKey(current_character) &&
                    character_map.containsValue(current_word)) return false;

            // IF CHARACTER AND WORD ARENT IN THE MAP, ADD THEM
            if (character_map.get(current_character) == null && !character_map.containsValue(current_word)) {
                character_map.put(current_character, current_word);
            }
        }

        return true;
    }
}
