package solutions.p1684;

import java.util.HashSet;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        if( words.length <= 0) return 0;

        HashSet<Character> integer_check = new HashSet<Character>();
        int valid_count = 0;

        for (int i = 0; i < allowed.length(); i++) {

            char character_at = allowed.charAt(i);
            integer_check.add(character_at);
        }

        for(String word : words) {

            boolean valid_this_one = true;
            for(int i = 0; i < word.length(); i++ ){

                boolean is_it_there = integer_check.contains(word.charAt(i));
                if( !is_it_there) {valid_this_one = false; break; }
            }

            if(valid_this_one) valid_count++;

        }

        return valid_count;
    }
}