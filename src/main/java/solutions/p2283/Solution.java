package solutions.p2283;

public class Solution {

    public boolean digitCount(String num) {
        int[] freq = new int[10];

        // count frequency of each digit
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        // check condition
        for (int i = 0; i < num.length(); i++) {
            if (freq[i] != num.charAt(i) - '0') {
                return false;
            }
        }

        return true;
    }
}
