package solutions.p67;
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int pointer_a = a.length() - 1;
        int pointer_b = b.length() - 1;
        StringBuilder result = new StringBuilder();

        while (pointer_a >= 0 || pointer_b >= 0 || carry != 0) {
            int current_binary_a = (pointer_a >= 0) ? a.charAt(pointer_a) - '0' : 0;
            int current_binary_b = (pointer_b >= 0) ? b.charAt(pointer_b) - '0' : 0;

            int current_sum = current_binary_a + current_binary_b + carry;
            result.append(current_sum % 2); // binary digit
            carry = current_sum / 2;        // carry for next

            pointer_a--;
            pointer_b--;
        }

        return result.reverse().toString();
    }
}
