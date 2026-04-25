package solutions.p520;

class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        // Case 1: all uppercase
        if (word.equals(word.toUpperCase())) return true;

        // Case 2: all lowercase
        if (word.equals(word.toLowerCase())) return true;

        // Case 3: first letter uppercase, rest lowercase
        String firstCapitalRestLower = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        return word.equals(firstCapitalRestLower);
    }
}