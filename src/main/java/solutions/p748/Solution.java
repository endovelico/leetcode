package solutions.p748;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];

        // Count letters required by the license plate
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                required[c - 'a']++;
            }
        }

        String answer = null;

        // Check every word
        for (String word : words) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // Check whether word contains all required letters
            boolean completing = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] < required[i]) {
                    completing = false;
                    break;
                }
            }

            // Keep the shortest valid word
            if (completing &&
                    (answer == null || word.length() < answer.length())) {
                answer = word;
            }
        }

        return answer;
    }
}
