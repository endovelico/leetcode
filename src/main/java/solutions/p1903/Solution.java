package solutions.p1903;

class Solution {
    public String largestOddNumber(String num) {
        int lastOddIndex = -1;

        // Find the last odd digit
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                lastOddIndex = i;
            }
        }

        // No odd digit found
        if (lastOddIndex == -1) return "";

        // Return substring from start to last odd digit (inclusive)
        return num.substring(0, lastOddIndex + 1);
    }
}
