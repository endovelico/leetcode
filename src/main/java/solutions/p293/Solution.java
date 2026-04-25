package solutions.p293;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();

        // loop till second last char to avoid out-of-bounds
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                // flip "++" to "--" at this position
                String next = currentState.substring(0, i) + "--" + currentState.substring(i + 2);
                result.add(next);
            }
        }

        return result;
    }
}