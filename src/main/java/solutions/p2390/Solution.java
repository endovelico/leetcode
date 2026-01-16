package solutions.p2390;

import java.util.Stack;

class Solution {

    public String removeStars(String s) {

        char[] character_array = s.toCharArray();
        Stack<Character> character_stack = new Stack<>();
        int cursor = 0;

        while (cursor < character_array.length) {

            char current = character_array[cursor];

            if (character_stack.isEmpty()) {
                character_stack.add(character_array[cursor]);

            } else {

               if(current == '*') { character_stack.pop();}
               else if( character_stack.add(current));
            }

            cursor++;
        }

        StringBuilder result = new StringBuilder();

        while(!character_stack.isEmpty()) result.append(character_stack.pop());


        return result.reverse().toString();
    }

}