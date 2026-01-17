package solutions.p131;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result_list = new ArrayList<>();
        backtracking_partition(0, s, new ArrayList<>(), result_list);
        return result_list;
    }

    private void backtracking_partition(int index, String str, ArrayList<String> current_list, List<List<String>> result_list) {

        // Base case: reached the end of the string
        if (index == str.length()) {
            result_list.add(new ArrayList<>(current_list));
            return;
        }

        // Try all possible substrings starting at index
        for (int i = index; i < str.length(); i++) {
            String candidate = str.substring(index, i + 1);

            // Only proceed if the substring is a palindrome
            if (isPalindrome(candidate)) {
                current_list.add(candidate); // choose
                backtracking_partition(i + 1, str, current_list, result_list); // recurse
                current_list.remove(current_list.size() - 1); // backtrack
            }
        }
    }

    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
