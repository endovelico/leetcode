package solutions.p1704;

public class Solution {

    public boolean halvesAreAlike(String s) {
        int balance = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("aeiouAEIOU".indexOf(c) != -1) {
                balance += (i < mid) ? 1 : -1;
            }
        }

        return balance == 0;
    }
}
