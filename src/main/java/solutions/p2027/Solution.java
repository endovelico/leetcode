package solutions.p2027;

class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == 'X') {
                // Make a move starting at i (covers i, i+1, i+2)
                moves++;
                i += 3; // skip the next two, since they’re flipped in this move
            } else {
                i++; // no move needed, just go to next character
            }
        }

        return moves;
    }
}
