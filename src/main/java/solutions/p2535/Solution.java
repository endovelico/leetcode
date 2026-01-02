package solutions.p2535;

public class Solution {

    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            elementSum += num;

            int x = num; // fazer de novo para os numeros.
            while (x > 0) {

                digitSum += x % 10;
                x /= 10;

            }
        }

        return Math.abs(elementSum - digitSum);
    }
}
