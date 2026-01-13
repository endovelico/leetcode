package solutions.p2521;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primes = new HashSet<>();

        for (int num : nums) {
            factor(num, primes);
        }

        return primes.size();
    }

    private void factor(int n, Set<Integer> primes) {
        for (int p = 2; p * p <= n; p++) {
            while (n % p == 0) {
                primes.add(p);
                n /= p;
            }
        }
        if (n > 1) {
            primes.add(n); // leftover prime
        }
    }
}
