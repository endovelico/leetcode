package solutions.p989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*
* Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
*
*
* */


class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        if(k == 0) return Arrays.stream(num).boxed().toList();

        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int cursor = num.length - 1;

        while(cursor >= 0 || k > 0 || carry > 0) {
            int n = (cursor >= 0) ? num[cursor] : 0;
            int digit = k % 10;

            int sum = n + digit + carry;
            carry = sum / 10;
            result.add(sum % 10);

            k /= 10;
            cursor--;
        }

        Collections.reverse(result);
        return result;
    }
}
