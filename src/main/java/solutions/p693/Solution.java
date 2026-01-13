package solutions.p693;

public class Solution {
    public boolean hasAlternatingBits(int n) {

        int previous_bit = n & 1; // Im getting the last bit

        n = n >> 1; // Shifts right, for exaample 1010  →  0101

        while (n > 0) {

            int current_bit = n & 1;

            if( current_bit == previous_bit) return false;

            previous_bit = current_bit;
            n = n >> 1;

        }

        return true;
    }
}
