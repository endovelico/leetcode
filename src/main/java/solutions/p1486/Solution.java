package solutions.p1486;

class Solution {
    public int xorOperation(int n, int start) {

        int end_at = n;
        int xor_result = 0;
        int index = 0;

        while (index < end_at) {
            xor_result ^= (start + 2 * index);
            index++;
        }

        return xor_result;
    }
}
