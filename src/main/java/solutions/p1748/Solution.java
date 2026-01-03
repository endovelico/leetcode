package solutions.p1748;

class Solution {
    public int sumOfUnique(int[] nums) {

        int[] frequency = new int[101];

        int sum = 0;

        for (int num : nums) {
            frequency[num]++;

            if (frequency[num] == 1) {
                sum += num;
            } else if (frequency[num] == 2) {
                sum -= num;
            }
        }

        return sum;
    }
}
