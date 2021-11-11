package solutions.p383;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        if( ransomNote == null || magazine == null ) return false;
        if( ransomNote.length() > magazine.length() ) return false;
        if( ransomNote.equals(magazine) ) return true;

        Map<Character, Integer> magazine_letters = new HashMap<Character, Integer>();
        int ransomNote_index = 0;

        for ( int i = 0; i < magazine.length(); i ++) {
            Integer magazine_letter_count = magazine_letters.get(magazine.charAt(i));
            magazine_letters.put(magazine.charAt(i), magazine_letter_count == null ? 1 : magazine_letter_count + 1);
        }

        while ( ransomNote_index < ransomNote.length() ) {
            char current_character = ransomNote.charAt(ransomNote_index);

            Integer current_character_result = magazine_letters.get(current_character);
            if( current_character_result == null || current_character_result == 0) return false;

            magazine_letters.put(current_character, current_character_result - 1);

            ransomNote_index++;
        }

        return true;
    }
}
