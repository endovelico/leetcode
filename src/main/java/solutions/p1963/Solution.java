package solutions.p1963;

class Solution {
    public int minSwaps(String s) {
        int balance = 0;   // number of unmatched '['
        int swaps = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else { // ']'
                if (balance > 0) {
                    balance--; // match with previous '['
                } else {
                    // unmatched ']'
                    swaps++;
                    balance++; // swap brings a '[' here
                }
            }
        }

        return swaps;
    }
}
