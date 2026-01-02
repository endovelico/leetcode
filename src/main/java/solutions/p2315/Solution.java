package solutions.p2315;

public class Solution {

    public int countAsterisks(String s) {
        int count = 0;
        boolean insideBars = false;

        for (char c : s.toCharArray()) {
            if (c == '|') {
                insideBars = !insideBars;
            } else if (c == '*' && !insideBars) {
                count++;
            }
        }

        return count;
    }
}
