package solutions.p2259;

class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        String maxNumber = "";

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                // Build number after removing this occurrence
                String candidate = number.substring(0, i) + number.substring(i + 1);

                // Keep the largest one
                if (candidate.compareTo(maxNumber) > 0) {
                    maxNumber = candidate;
                }
            }
        }

        return maxNumber;
    }
}
