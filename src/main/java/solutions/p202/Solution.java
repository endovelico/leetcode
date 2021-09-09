package solutions.p202;

import java.util.HashSet;

public class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> number_set = new HashSet<>();
        int total_count = 0;

        return isHappyHelper(n, total_count, number_set);
    }

    public boolean isHappyHelper(int n, int total_count, HashSet<Integer> number_set) {

        if(n == 1) return true;
        int last_digit = -1;

        while(n != 0) {
            last_digit = n % 10;
            n = n / 10;
            int last_digit_powered = last_digit * last_digit;
            total_count += last_digit_powered;
        }

        if( number_set.contains(total_count) ) return false;
        number_set.add(total_count);

        return isHappyHelper(total_count, 0, number_set);
    }
}