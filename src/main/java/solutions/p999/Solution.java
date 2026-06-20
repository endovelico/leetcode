package solutions.p999;

class Solution {
    public int numRookCaptures(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int rookRow = -1, rookCol = -1;

        // Step 1: find the rook
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                }
            }
        }

        int captures = 0;

        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] d : dirs) {
            int r = rookRow + d[0];
            int c = rookCol + d[1];

            while (r >= 0 && r < m && c >= 0 && c < n) {
                if (board[r][c] == 'B') break;
                if (board[r][c] == 'p') {
                    captures++;
                    break;
                }
                r += d[0];
                c += d[1];
            }
        }

        return captures;
    }
}