package solutions.p17;

import java.util.List;

import java.util.*;

class Solution {
    private final String[] KEYPAD = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: we have chosen one letter for each digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to the current digit
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

        // Try each letter and recurse
        for (char c : letters.toCharArray()) {
            current.append(c);                  // Choose
            backtrack(digits, index + 1, current, result); // Recurse to next digit
            current.deleteCharAt(current.length() - 1);   // Undo choice (backtrack)
        }
    }
}
