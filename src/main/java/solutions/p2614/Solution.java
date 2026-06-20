package solutions.p2614;

class Solution {
    public int diagonalPrime(int[][] nums) {

        int n = nums.length;
        int maxPrime = 0;

        for (int i = 0; i < n; i++) {

            // main diagonal
            int main = nums[i][i];
            if (isPrime(main)) {
                maxPrime = Math.max(maxPrime, main);
            }

            // anti-diagonal
            int anti = nums[i][n - 1 - i];
            if (isPrime(anti)) {
                maxPrime = Math.max(maxPrime, anti);
            }
        }

        return maxPrime;
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}