package solutions.p1572;

class Solution {

    public int diagonalSum(int[][] mat) {

        int total_sum = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++) {
                if (i == j || i + j == mat.length - 1) {
                    total_sum += mat[i][j];
                }
            }
        }

        // Devolver array.asList
        return total_sum;
    }
}