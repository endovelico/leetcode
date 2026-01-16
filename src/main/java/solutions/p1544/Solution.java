package solutions.p1544;

import java.util.Stack;

class Solution {

    public String makeGood(String s) {

        char[] character_array = s.toCharArray();
        Stack<Character> character_stack = new Stack<>();
        int cursor = 0;

        while (cursor < character_array.length) {

            if (character_stack.isEmpty()) {
                character_stack.add(character_array[cursor]);
            } else {

                char current = character_array[cursor];
                char peeked_character = character_stack.peek();

                if (itIsBadMatch(current, peeked_character)) {
                    character_stack.pop();
                } else {
                    character_stack.add(current);
                }
            }

            cursor++;
        }

        StringBuilder result = new StringBuilder();

        // IMPORTANT: pop until empty (not size-based loop)
        while (!character_stack.isEmpty()) {
            result.append(character_stack.pop());
        }

        return result.reverse().toString();
    }

    private boolean itIsBadMatch(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b)
                && a != b;
    }

}
