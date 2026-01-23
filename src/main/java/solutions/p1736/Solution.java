package solutions.p1736;

class Solution {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        // Hour tens
        if (chars[0] == '?') {
            chars[0] = (chars[1] == '?' || chars[1] <= '3') ? '2' : '1';
        }

        // Hour ones
        if (chars[1] == '?') {
            chars[1] = (chars[0] == '2') ? '3' : '9';
        }

        // Minute tens
        if (chars[3] == '?') {
            chars[3] = '5';
        }

        // Minute ones
        if (chars[4] == '?') {
            chars[4] = '9';
        }

        return new String(chars);
    }
}
