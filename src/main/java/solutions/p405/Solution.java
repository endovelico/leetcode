package solutions.p405;

class Solution {

    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Handle negative numbers by converting to long
        long n = num & 0xFFFFFFFFL; // treat num as unsigned

        while (n != 0) {
            int remainder = (int)(n % 16);
            sb.append(hexChars[remainder]);
            n /= 16;
        }

        return sb.reverse().toString();
    }
}
