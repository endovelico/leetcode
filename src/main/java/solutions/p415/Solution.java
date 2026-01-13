package solutions.p415;

class Solution {

    /*
    * | Character | ASCII Code (Decimal) | ASCII Code (Hex) |
        | --------- | -------------------- | ---------------- |
        | `'0'`     | 48                   | 0x30             |
        | `'1'`     | 49                   | 0x31             |
        | `'2'`     | 50                   | 0x32             |
        | `'3'`     | 51                   | 0x33             |
        | `'4'`     | 52                   | 0x34             |
        | `'5'`     | 53                   | 0x35             |
        | `'6'`     | 54                   | 0x36             |
        | `'7'`     | 55                   | 0x37             |
        | `'8'`     | 56                   | 0x38             |
        | `'9'`     | 57                   | 0x39             |

    *
    *
    * */


    public String addStrings(String num1, String num2) {

        if( num1.isEmpty() || num1.equals("0")) return num2;
        if( num2.isEmpty() || num2.equals("0")) return num1;

        StringBuilder result = new StringBuilder();
        int pointer_1 = num1.length() - 1;
        int pointer_2 = num2.length() - 1;
        int carry = 0;

        while ( pointer_1 >= 0 || pointer_2 >= 0 || carry != 0 ) {

        int digit_1 = (pointer_1 >= 0) ? num1.charAt(pointer_1) - '0' : 0;
        int digit_2 = (pointer_2 >= 0) ? num2.charAt(pointer_2) - '0' : 0;

         int sum = digit_1 + digit_2 + carry;
         result.append(sum % 10);
         carry = sum / 10;

         pointer_1--;
         pointer_2--;
        }

        return result.reverse().toString();
    }
}