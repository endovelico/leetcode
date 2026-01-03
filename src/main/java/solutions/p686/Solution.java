package solutions.p686;

public class Solution {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Repeat until length >= b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check current and next 2 repeats
        for (int i = 0; i < 2; i++) {
            if (sb.indexOf(b) != -1) {
                return count;
            }
            sb.append(a);
            count++;
        }

        return -1;
    }



}
