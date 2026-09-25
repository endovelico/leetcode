package solutions.p819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // Store banned words
        Set<String> bannedSet = new HashSet<>();

        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        // Count word frequencies
        Map<String, Integer> frequency = new HashMap<>();

        String[] words = paragraph.toLowerCase().split("[^a-z]+");

        String answer = "";
        int maxFrequency = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }

            int count = frequency.getOrDefault(word, 0) + 1;
            frequency.put(word, count);

            if (count > maxFrequency) {
                maxFrequency = count;
                answer = word;
            }
        }

        return answer;
    }
}