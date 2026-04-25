package solutions.p294;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean canWin(String currentState) {
        // Check memo to avoid recomputation
        if (memo.containsKey(currentState)) {
            return memo.get(currentState);
        }

        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                // Flip "++" to "--"
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);

                // If opponent cannot win from this state, current player can win
                if (!canWin(nextState)) {
                    memo.put(currentState, true);
                    return true;
                }
            }
        }

        // If all moves lead to opponent winning, current player loses
        memo.put(currentState, false);
        return false;
    }
}