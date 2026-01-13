package solutions.p762;

import java.math.BigInteger;
import java.util.Set;

class Solution {
    public int countPrimeSetBits(int left, int right) {

        int final_count = 0;
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

        for (int start_index = left; start_index <= right; start_index++) {

            if (primes.contains(Integer.bitCount(start_index))) {
                final_count++;
            }
        }

        return final_count;
    }

    private int count_set_bits(int number_to_count) {

        // we shift, until the number is not higher than 0
        int bit_counter = 0;
        while (number_to_count > 0) {

            int current_bit = number_to_count & 1;
            if(current_bit == 1) bit_counter++;

            number_to_count = number_to_count >> 1;

        }

        return bit_counter;
    }
}