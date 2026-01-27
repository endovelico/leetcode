package solutions.p1974;

class Solution {
    public int minTimeToType(String word) {
        int totalTime = 0;
        char currentChar = 'a';  // pointer starts at 'a'

        for (char targetChar : word.toCharArray()) {
            int distance = Math.abs(targetChar - currentChar);
            int minMoves = Math.min(distance, 26 - distance); // circular distance
            totalTime += minMoves + 1; // add 1 for typing the character
            currentChar = targetChar;  // move pointer to current character
        }

        return totalTime;
    }
}
