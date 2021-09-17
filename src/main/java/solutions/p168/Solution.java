package solutions.p168;

public class Solution {

    private static final int char_offset = 64;

    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            int current_char_number = columnNumber % 26;
            char current_char = (char) (char_offset + current_char_number);

            if(current_char_number == 0) {
                current_char = 'Z';
                columnNumber = columnNumber / 26 - 1;
            } else{
                columnNumber = columnNumber / 26;
            }

            result.append(current_char);
        }

        return result.reverse().toString();
    }

    public static void main(String args[]) {

        Solution solution = new Solution();
        solution.convertToTitle(701);
    }
}