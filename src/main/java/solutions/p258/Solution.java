package solutions.p258;

public class Solution {

    public int addDigits(int num) {

        if (num == 0) return 0;
        return (num - 1) % 9 + 1;
    }

    public int addDigitsNaive(int num) {

        // Repeat until the number is a single digit
        while (num >= 10) {

            int sum = 0;

            // Add digits one by one
            while (num > 0) {
                sum += num % 10; // last digit
                num /= 10;       // remove last digit
            }

            num = sum; // repeat with the new sum
        }

        return num;
    }

    public static void main(String[] args) {


    }
}
