package solutions.p1678;

class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if (c == 'G') {
                sb.append('G');
            } else if (command.charAt(i + 1) == ')') {
                sb.append('o');
                i++; // skip ')'
            } else {
                sb.append("al");
                i += 3; // skip "al)"
            }
        }

        return sb.toString();
    }
}
