package solutions.p1837;

class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;  // add least significant digit in base k
            n /= k;        // remove that digit
        }
        return sum;
    }
}
