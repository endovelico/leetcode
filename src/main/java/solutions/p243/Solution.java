package solutions.p243;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int lastWord1 = -1;
        int lastWord2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                lastWord1 = i;
            } else if (wordsDict[i].equals(word2)) {
                lastWord2 = i;
            }

            if (lastWord1 != -1 && lastWord2 != -1) {
                minDistance = Math.min(
                        minDistance,
                        Math.abs(lastWord1 - lastWord2)
                );
            }
        }

        return minDistance;
    }
}


