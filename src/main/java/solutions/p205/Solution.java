package solutions.p205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> character_map = new HashMap<Character, Character>();

        for (int index = 0; index < s.length(); index++) {
            Character current_character_one = s.charAt(index);
            Character current_character_two = t.charAt(index);

            // IF THIS S-CHARACTER IS ALREADY MAPPED TO A DIFFERENT CHARACTER OTHER THAN THE T-CHARACTER
            if (character_map.get(current_character_one) != null &&
                    !character_map.get(current_character_one).equals(current_character_two)) return false;

            // IF CHARACTER ISNT IN THE MAP, BUT SECOND CHARACTER IS ON SET = FALSE
            if(!character_map.containsKey(current_character_one) &&
                    character_map.containsValue(current_character_two)) return false;

            // IF BOTH CHARACTERS ARENT IN THE MAP AND SET, ADD THEM
            if (character_map.get(current_character_one) == null && !character_map.containsValue(current_character_two)) {
               character_map.put(current_character_one, current_character_two);
            }
        }

        return true;
    }
}