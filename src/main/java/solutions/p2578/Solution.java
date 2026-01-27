package solutions.p2578;

import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        // Convert number to array of digits
        String numStr = String.valueOf(num);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        // Sort digits in ascending order
        Arrays.sort(digits);

        // Distribute digits alternately to two numbers
        int num1 = 0, num2 = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + digits[i];
            } else {
                num2 = num2 * 10 + digits[i];
            }
        }

        // Return sum of the two numbers
        return num1 + num2;
    }
}
