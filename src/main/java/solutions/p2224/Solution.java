package solutions.p2224;

class Solution {
    public int convertTime(String current, String correct) {
        // Convert time strings to total minutes
        int currentMinutes = toMinutes(current);
        int correctMinutes = toMinutes(correct);

        int diff = correctMinutes - currentMinutes;
        int moves = 0;

        // Greedy: subtract largest possible increment at each step
        int[] increments = {60, 15, 5, 1};
        for (int inc : increments) {
            moves += diff / inc;    // how many times we can subtract this increment
            diff %= inc;            // remaining difference
        }

        return moves;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
