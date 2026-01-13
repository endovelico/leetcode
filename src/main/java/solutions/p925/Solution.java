package solutions.p925;

class Solution {
    public boolean isLongPressedName(String name, String typed) {

        int cursor_name = 0;
        int cursor_typed = 0;

        while (cursor_typed < typed.length()) {

            if (cursor_name < name.length() && name.charAt(cursor_name) == typed.charAt(cursor_typed)) {
                // Characters match, move both pointers
                cursor_name++;
            } else if (cursor_typed == 0 || typed.charAt(cursor_typed) != typed.charAt(cursor_typed - 1)) {
                // Not a match and not a valid long press
                return false;
            }

            // Always move typed pointer
            cursor_typed++;
        }

        // Check if we consumed all of name
        return cursor_name == name.length();
    }
}