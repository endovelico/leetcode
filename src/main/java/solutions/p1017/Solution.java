package solutions.p1017;

class Solution {

    public String baseNeg2(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        int base = -2;

        while (n != 0) {
            int remainder = n % base;
            n = n / base;

            if (remainder < 0) {
                remainder += 2; // adjust remainder to be non-negative
                n += 1;         // adjust quotient
            }

            sb.append(remainder);
        }

        return sb.reverse().toString();
    }

}