package solutions.p66;

class Solution {
    public int[] plusOne(int[] digits) {

        int cursor = digits.length - 1;

        while (cursor >= 0) {
            if (digits[cursor] < 9) {
                digits[cursor]++;
                return digits;
            }
            digits[cursor] = 0;
            cursor--;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
